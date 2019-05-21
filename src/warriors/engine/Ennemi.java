package warriors.engine;

public class Ennemi extends Cases {
    int pv =0;
    int pa =0;
    public Ennemi(String nameCase, int pv, int pa) {
        super(nameCase);
        setPa(pa);
        setPv(pv);
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPa() {
        return pa;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

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

    @Override
    public String toString() {
        res = super.toString();
        return res += "PA Ennemi : " + getPa() + "\n" + "PV Ennemi : " + getPv();
    }

    //    @Override
//    public String getTypeCase() {
//        return super.getTypeCase();
//    }
//
//    @Override
//    public void setTypeCase(String typeCase) {
//        super.setTypeCase(typeCase);
//    }
//
//    @Override
//    public String getNameCase() {
//        return super.getNameCase();
//    }
//
//    @Override
//    public void setNameCase(String nameCase) {
//        super.setNameCase(nameCase);
//    }
//
//    @Override
//    public int getNumberCase() {
//        return super.getNumberCase();
//    }
//
//    @Override
//    public void setNumberCase(int numberCase) {
//        super.setNumberCase(numberCase);
//    }
}
