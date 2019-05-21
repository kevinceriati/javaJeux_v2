package warriors.engine;

public class Guerrier extends Personnage {

    public Guerrier (String name, String image, int life, int attackLevel) {
        super(name, image, life,attackLevel);
    }

    @Override
    public void addAtk(int newAtk) {
        if (getAttackLevel() < 10){
            setAttackLevel(getAttackLevel() + newAtk);
            if (getAttackLevel() >= 10){
                setAttackLevel(10);
            }
        }
    }

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
