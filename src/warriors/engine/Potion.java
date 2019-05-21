package warriors.engine;


public class Potion extends Cases {
    int life = 0;

    public Potion(String nameCase, int life) {
        super(nameCase);
        setLife(life);
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    @Override
    public void applyTreatment(Personnage hero) {
        hero.addLife(getLife());
    }

    @Override
    public String toString() {
        res = super.toString();
        return res += "Bonus pv : " + getLife();
    }
}
