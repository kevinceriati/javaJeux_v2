package warriors.engine;

import java.io.BufferedReader;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import warriors.contracts.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

public class Warriors implements WarriorsAPI {
    private List<Hero> myHero;
    private List<Map> myMap;
    int warrior = 0;
    int i = 0;
    int de = 0;
    State jeuEnCours;
    Hashtable<String, State> allState;
    String[] data;
    Hero backupHero = null;

    /**
     * Creat Hero list
     */

    public Warriors() {
        boolean isTest = false;
//        Personnage test = new Magicien("Al Batar", "tete de de con", 5, 5);
//        Personnage triste = new Magicien("Al Conar", "tete de cul", 5, 5);
//        Personnage Yolo = new Guerrier("Ragnare le Salopare", "tete de cul", 2, 9);
        myHero = new ArrayList<>();
//        myHero.add(test);
//        myHero.add(triste);
//        myHero.add(Yolo);
        myMap = new ArrayList<>();
        loadMaps();
//        writeMaps();

        //   Code for CSV test

        if (isTest = true) {
            BufferedReader csvReader = null;
            String row = "";
            try {
                csvReader = new BufferedReader(new FileReader("./Java_Warriors_CodeDeBase/src/warriors/scenario.csv"));
                while ((row = csvReader.readLine()) != null) {
                    data = row.split(",");
                }
                csvReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return
     */
    @Override
    public List<Hero> getHeroes() {
        return myHero;
    }

    /**
     * @return
     */
    @Override
    public List<Map> getMaps() {
        return myMap;
    }

    /**
     * @param playerName the name of the player
     * @param hero       the chosen hero for the game
     * @param map        the chosen map for the game
     * @return Start of the game
     */
    @Override
    public GameState createGame(String playerName, Hero hero, Map map) {
        State start = new State(playerName, hero, map, Integer.toString(warrior));
        try {
            backupHero = (Hero) hero.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        allState = new Hashtable();
        allState.put(Integer.toString(warrior), start);
        warrior++;
        return start;
    }

    /**
     * @param gameID the ID of the game
     *               Course of the game with game rules
     * @return current game set by State
     */
    @Override
    public GameState nextTurn(String gameID) {
        //definir partie en cours
        Plateau myPlateau = (Plateau) myMap.get(0);
        jeuEnCours = allState.get(gameID);

        //deplacement joueur
        jeuEnCours.setCurrentCase(jeuEnCours.getCurrentCase() + de);

        if (jeuEnCours.getCurrentCase() >= jeuEnCours.getMap().getNumberOfCase()) {
            System.out.println(jeuEnCours.getMap().getNumberOfCase()    );
            jeuEnCours.setGameStatus(GameStatus.FINISHED);
            jeuEnCours.setLastLog("Merci camarade, le jeu est terminer ◄◄◄◄ ");
            jeuEnCours.getHero().setLife(backupHero.getLife());
            jeuEnCours.getHero().setAttackLevel(backupHero.getAttackLevel());
        } else if (jeuEnCours.getHero().getLife() <= 0) {
            jeuEnCours.setGameStatus(GameStatus.GAME_OVER);
            jeuEnCours.setLastLog("Vous etes mort merci au revoir t nul");
            jeuEnCours.getHero().setLife(backupHero.getLife());
            jeuEnCours.getHero().setAttackLevel(backupHero.getAttackLevel());
        } else {
            myPlateau.getCasesList().get(jeuEnCours.getCurrentCase()).applyTreatment((Personnage) jeuEnCours.getHero());
            String nomCase = ((Plateau) jeuEnCours.getMap()).getCasesList().get(jeuEnCours.getCurrentCase()).getNameCase();
            jeuEnCours.setLastLog("le dé a fait " + de + " Vous êtes maintenant case : " + jeuEnCours.getCurrentCase() + "\n" +
                    myPlateau.getCasesList().get(jeuEnCours.getCurrentCase()) + "\n" +
                    jeuEnCours.getHero());
            jeuEnCours.setGameStatus(GameStatus.IN_PROGRESS);
        }
        return jeuEnCours;
    }

    /**
     * @param gameID
     * @return Scenario CSV Debug mode
     */
    public GameState nextTurnTest(String gameID) {
        de = Integer.valueOf(data[i]);
        i++;
        return nextTurn(gameID);
    }

    /**
     * @param gameID
     * @return Ordinaire game with random dice
     */

    public GameState rollDice(String gameID) {
        //jet de des
        de = 1 + (int) (Math.random() * ((6 - 1) + 1));
        return nextTurn(gameID);
    }

    public void loadMaps() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Cases.class, new Serializer());
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        try {
            File folder = new File("./Maps");
            File[] listOfFiles = folder.listFiles();

            for (File file : listOfFiles) {
                if (file.isFile()) {

                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getPath()));
                    Plateau board = gson.fromJson(bufferedReader, Plateau.class);
//			System.out.println(board.getClass());
//			System.out.println(board.toString());
                    myMap.add(board);
                }
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeMaps(Map choosenMap) {

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Cases.class, new Serializer());
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String json = gson.toJson(choosenMap);

        // écriture du fichier

        try {
            Files.write(Paths.get("./Maps/" + UUID.randomUUID().toString() + ".json"), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}