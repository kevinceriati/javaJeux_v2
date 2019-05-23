package warriors.engine;

public class Arme extends Cases {
    int degat =0;

    /**
     * @param nameCase
     * @param degat
     */
    public Arme(String nameCase, int degat) {
        super(nameCase);
        setDegat(degat);
    }

    /**
     * @return
     */
    public int getDegat() {
        return degat;
    }

    /**
     * @param degat
     */
    public void setDegat(int degat) {
        this.degat = degat;
    }

    /**
     * @param hero
     */
    @Override
    public void applyTreatment(Personnage hero) {
       hero.addAtk(getDegat());
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        res = super.toString();
        return res += "Bonus dégat : " + getDegat();
    }
}
