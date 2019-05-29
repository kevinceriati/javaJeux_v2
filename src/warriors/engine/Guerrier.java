package warriors.engine;

public class Guerrier extends Personnage {

    /**
     * @param name
     * @param image
     * @param life
     * @param attackLevel
     */
    public Guerrier (String name, String type, String image, int attackLevel, int life) {
        super(name, image, type, life, attackLevel);
    }

    public  Guerrier() {}

    /**
     * @param newAtk
     */
    @Override
    public void addAtk(int newAtk) {
//        int letAtk = Math.min( 10, getAttackLevel() + newAtk);
//        setAttackLevel(letAtk);
        if ((getAttackLevel() + newAtk) < 10){
            setAttackLevel(getAttackLevel() + newAtk);
        }else if ((getAttackLevel() + newAtk) >= 10){
            setAttackLevel(10);
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

    @Override
    public String toString() {
        return super.toString();
    }


}
