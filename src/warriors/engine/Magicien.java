package warriors.engine;

public class Magicien extends Personnage {


    public Magicien (String name, String image, int life, int attackLevel) {
       super(name, image, life,attackLevel);
    }

    public void addAtk(int newAtk) {
        if (getAttackLevel() < 15){
            setAttackLevel(getAttackLevel() + newAtk);
            if (getAttackLevel() >= 15){
                setAttackLevel(15);
            }
        }
    }
    public void addLife(int newLife) {
        if (getLife() < 6){
            setLife(getLife() + newLife);
            if (getLife() >= 6 ){
                setLife(6);
            }
        }
    }
    @Override
    public String toString() {
        return super.toString();
    }
}

