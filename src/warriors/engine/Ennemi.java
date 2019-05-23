package warriors.engine;

public class Ennemi extends Cases {
    int pv =0;
    int pa =0;

    /**
     * @param nameCase
     * @param pv
     * @param pa
     */
    public Ennemi(String nameCase, int pv, int pa) {
        super(nameCase);
        setPa(pa);
        setPv(pv);
    }

    /**
     * @return
     */
    public int getPv() {
        return pv;
    }

    /**
     * @param pv
     */
    public void setPv(int pv) {
        this.pv = pv;
    }

    /**
     * @return
     */
    public int getPa() {
        return pa;
    }

    /**
     * @param pa
     */
    public void setPa(int pa) {
        this.pa = pa;
    }

    /**
     * @param hero
     */
    @Override
    public void applyTreatment(Personnage hero) {
        boolean combat = true;
        while(combat){
            pv -= hero.getAttackLevel();
            if(pv > 0){
                hero.setLife(hero.getLife()-pa);
            }
            if(hero.getLife() <= 0 || pv <= 0){
                combat = false;
            }
        }
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        res = super.toString();
        return res += "PA Ennemi : " + getPa() + "\n" + "PV Ennemi : " + getPv();
    }
}
