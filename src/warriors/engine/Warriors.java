package warriors.engine;
import warriors.contracts.GameState;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;

import java.util.ArrayList;
import java.util.List;

public class Warriors implements WarriorsAPI {

    @Override
    public List<Hero> getHeroes() {
        Personnage test = new Magicien("Al Batar", "tete de de con", 5, 5);
        Personnage triste = new Magicien("Al Conar", "tete de cul", 5, 5);
        Personnage Yolo = new Guerrier("Ragnare le Salopare", "tete de cul", 2, 9);
        List<Hero> myHero = new ArrayList<>();
        myHero.add(test);
        myHero.add(triste);
        myHero.add(Yolo);

        return  myHero;
    }

    @Override
    public List<Map> getMaps() {
        return null;
    }

    @Override
    public GameState createGame(String playerName, Hero hero, Map map) {
        return null;
    }

    @Override
    public GameState nextTurn(String gameID) {
        return null;
    }
}
