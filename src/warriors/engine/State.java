package warriors.engine;

import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;

import java.util.ArrayList;
import java.util.List;

public class State implements GameState {
    private String pName;
    private String  gId;
    private GameStatus gameStatus;
    private Hero hero;
    private Map map;
    int position = 0;
    String lastLog = "debut de partie";

    public State (String pName, Hero hero,  Map map, String gId){
        this.pName = pName;
        this.hero = hero;
        this.map = map;
        this.gId = gId;
        this.position = 0;
        gameStatus = GameStatus.IN_PROGRESS;
    }

    @Override
    public String getPlayerName() {
        return pName;
    }

    @Override
    public String getGameId() {
        return gId;
    }

    @Override
    public GameStatus getGameStatus() {
            return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    @Override
    public Hero getHero() {
        return this.hero;
    }

    @Override
    public Map getMap() {
        return map;
    }

    @Override
    public String getLastLog() {
        return lastLog;
    }

    public void setLastLog(String text) {
        this.lastLog = text;
    }

    @Override
    public int getCurrentCase() {
        return position;
    }

    public void setCurrentCase(int pos){
        this.position = pos;
    }



//    List<Hero> myHero = new ArrayList<>();
}
