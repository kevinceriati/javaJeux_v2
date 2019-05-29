package warriors.engine;

public class Magicien extends Personnage {

    /**
     * @param name
     * @param image
     * @param life
     * @param attackLevel
     */
    public Magicien (String name, String type, String image, int attackLevel, int life) {
       super(name, type, image, life,attackLevel);
    }

    /**
     * @param newAtk
     */
    public void addAtk(int newAtk) {
        if (getAttackLevel() < 15){
            setAttackLevel(getAttackLevel() + newAtk);
            if (getAttackLevel() >= 15){
                setAttackLevel(15);
            }
        }
    }

    /**
     * @param newLife
     */
    public void addLife(int newLife) {
        if (getLife() < 6){
            setLife(getLife() + newLife);
            if (getLife() >= 6 ){
                setLife(6);
            }
        }
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }
}

