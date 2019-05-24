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

    /**
     * @param pName
     * @param hero
     * @param map
     * @param gId
     */
    public State (String pName, Hero hero,  Map map, String gId){
        this.pName = pName;
        this.hero = hero;
        this.map = map;
        this.gId = gId;
        this.position = 0;
        gameStatus = GameStatus.IN_PROGRESS;
    }

    /**
     * @return
     */
    @Override
    public String getPlayerName() {
        return pName;
    }

    /**
     * @return
     */
    @Override
    public String getGameId() {
        return gId;
    }

    /**
     * @return
     */
    @Override
    public GameStatus getGameStatus() {
            return gameStatus;
    }

    /**
     * @param gameStatus
     */
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    /**
     * @return
     */
    @Override
    public Hero getHero() {
        return this.hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    /**
     * @return
     */
    @Override
    public Map getMap() {
        return map;
    }

    /**
     * @return
     */
    @Override
    public String getLastLog() {
        return lastLog;
    }

    /**
     * @param text
     */
    public void setLastLog(String text) {
        this.lastLog = text;
    }

    /**
     * @return
     */
    @Override
    public int getCurrentCase() {
        return position;
    }

    /**
     * @param pos
     */
    public void setCurrentCase(int pos){
        this.position = pos;
    }



//    List<Hero> myHero = new ArrayList<>();
}
