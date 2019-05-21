package warriors.engine;

public class Arme extends Cases {
    int degat =0;
    public Arme(String nameCase, int degat) {
        super(nameCase);
        setDegat(degat);
    }

    public int getDegat() {
        return degat;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }

    @Override
    public void applyTreatment(Personnage hero) {
       hero.addAtk(getDegat());
    }

    @Override
    public String toString() {
        res = super.toString();
        return res += "Bonus dégat : " + getDegat();
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
