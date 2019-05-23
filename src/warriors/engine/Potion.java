package warriors.engine;


public class Potion extends Cases {
    int life = 0;

    /**
     * @param nameCase
     * @param life
     */
    public Potion(String nameCase, int life) {
        super(nameCase);
        setLife(life);
    }

    /**
     * @param life
     */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     * @return
     */
    public int getLife() {
        return life;
    }

    /**
     * @param hero
     */
    @Override
    public void applyTreatment(Personnage hero) {
        hero.addLife(getLife());
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        res = super.toString();
        return res += "Bonus pv : " + getLife();
    }
}
