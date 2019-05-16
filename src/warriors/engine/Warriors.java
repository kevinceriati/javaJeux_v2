package warriors.engine;
import warriors.contracts.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Warriors implements WarriorsAPI {
    private List<Hero> myHero;
    private List<Map> myMap;
    int warrior = 0;
    State jeuEnCours;
    Hashtable<String, State> allState;

    public Warriors (){
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
        State start = new State (playerName, hero, map, Integer.toString(warrior));
        allState = new Hashtable();
        allState.put(Integer.toString(warrior), start);
        warrior++;
        return start;
    }

    @Override
    public GameState nextTurn(String gameID) {
//        State currentState = allState.get(gameID);
        //definir partie en cours
        jeuEnCours = allState.get(gameID);

        //jet de des
        int de = 1 + (int) (Math.random()*((6 - 1) + 1));

        //deplacement joueur
        jeuEnCours.setCurrentCase(jeuEnCours.getCurrentCase()+de);

        //log du joueur
        jeuEnCours.setLastLog("le dé a fait " + de + " Vous êtes maintenant case : " + jeuEnCours.getCurrentCase() + "");

        //condition quand passer 64

        if (jeuEnCours.getCurrentCase() == 64){
            jeuEnCours.setGameStatus(GameStatus.FINISHED);
            jeuEnCours.setLastLog("Merci camarade, le jeu est terminer ◄◄◄◄");
        }

        return jeuEnCours;
    }
}