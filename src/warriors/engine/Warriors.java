package warriors.engine;
import java.io.BufferedReader;
import java.io.FileReader;
import warriors.contracts.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Warriors implements WarriorsAPI {
    private List<Hero> myHero;
    private List<Map> myMap;
    int warrior = 0;
    int i = 0;
    int de = 0;
    State jeuEnCours;
    Hashtable<String, State> allState;
    String[] data;

    public Warriors() {
        boolean isTest = false;
        Personnage test = new Magicien("Al Batar", "tete de de con", 5, 5);
        Personnage triste = new Magicien("Al Conar", "tete de cul", 5, 5);
        Personnage Yolo = new Guerrier("Ragnare le Salopare", "tete de cul", 2, 9);
        myHero = new ArrayList<>();
        myHero.add(test);
        myHero.add(triste);
        myHero.add(Yolo);
        Plateau carte = new Plateau("Donjon de sa maman", 64);
        myMap = new ArrayList<>();
        myMap.add(carte);

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

    @Override
    public List<Hero> getHeroes() {
        return myHero;
    }

    @Override
    public List<Map> getMaps() {
        return myMap;
    }

    @Override
    public GameState createGame(String playerName, Hero hero, Map map) {
        State start = new State(playerName, hero, map, Integer.toString(warrior));
        allState = new Hashtable();
        allState.put(Integer.toString(warrior), start);
        warrior++;
        return start;
    }

    @Override
    public GameState nextTurn(String gameID) {
        //definir partie en cours
        Plateau myPlateau = (Plateau) myMap.get(0);
        jeuEnCours = allState.get(gameID);


        //deplacement joueur
        jeuEnCours.setCurrentCase(jeuEnCours.getCurrentCase() + de);

        if (jeuEnCours.getCurrentCase() >= 64) {
            jeuEnCours.setGameStatus(GameStatus.FINISHED);
            jeuEnCours.setLastLog("Merci camarade, le jeu est terminer ◄◄◄◄ ");
        } else if (jeuEnCours.getHero().getLife() <= 0) {
            jeuEnCours.setGameStatus(GameStatus.GAME_OVER);
            jeuEnCours.setLastLog("Vous etes mort merci au revoir t nul");
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


    public GameState nextTurnTest(String gameID) {
       de = Integer.valueOf(data[i]);
       i++;
    return nextTurn(gameID);
    }

public GameState rollDice(String gameID){
    //jet de des
    de = 1 + (int) (Math.random() * ((6 - 1) + 1));
    return nextTurn(gameID);
}
}