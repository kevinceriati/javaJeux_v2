package warriors.engine;

import java.util.ArrayList;

public class Arme extends Cases {
    int degat =0;
    protected  String weaponType;

    /**
     * @param nameCase
     * @param degat
     */
    public Arme(String nameCase, int degat, String weaponType) {
        super(nameCase);
        this.weaponType = weaponType;
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
        if(canBeUseBy(hero)) {
            hero.addAtk(getDegat());
        }
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        res = super.toString();
        return res += "Bonus dégat : " + getDegat();
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }


    public boolean canBeUseBy(Personnage hero){
        if(hero instanceof Guerrier && getWeaponType().equals("cac")){
            return true;
        }else if(hero instanceof Magicien && getWeaponType().equals("spell")){
            return true;
        }
        return false;
    }
}
