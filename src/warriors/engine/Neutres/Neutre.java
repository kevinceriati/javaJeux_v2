package warriors.engine.Neutres;

import warriors.engine.Cases;
import warriors.engine.Personnage;

public class Neutre extends Cases {
    public Neutre(String nameCase) {
        super(nameCase);
    }

    @Override
    public Personnage applyTreatment(Personnage hero) {
        return hero;
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
