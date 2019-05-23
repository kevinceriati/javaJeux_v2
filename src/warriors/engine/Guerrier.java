package warriors.engine;

public class Guerrier extends Personnage {

    /**
     * @param name
     * @param image
     * @param life
     * @param attackLevel
     */
    public Guerrier (String name, String image, int life, int attackLevel) {
        super(name, image, life,attackLevel);
    }

    /**
     * @param newAtk
     */
    @Override
    public void addAtk(int newAtk) {
        if (getAttackLevel() < 10){
            setAttackLevel(getAttackLevel() + newAtk);
            if (getAttackLevel() >= 10){
                setAttackLevel(10);
            }
        }
    }

    /**
     * @param newLife
     */
    @Override
    public void addLife(int newLife) {
        if (getLife() < 10){
            setLife(getLife() + newLife);
            if (getLife() >= 10 ){
                setLife(10);
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
