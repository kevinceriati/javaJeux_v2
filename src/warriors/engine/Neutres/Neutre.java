package warriors.engine.Neutres;

import warriors.engine.Cases;

public class Neutre extends Cases {
    public Neutre(int numberCase, String typeCase, String nameCase) {
        super(numberCase, typeCase, nameCase);
    }

    @Override
    public String getTypeCase() {
        return super.getTypeCase();
    }

    @Override
    public void setTypeCase(String typeCase) {
        super.setTypeCase(typeCase);
    }

    @Override
    public String getNameCase() {
        return super.getNameCase();
    }

    @Override
    public void setNameCase(String nameCase) {
        super.setNameCase(nameCase);
    }

    @Override
    public int getNumberCase() {
        return super.getNumberCase();
    }

    @Override
    public void setNumberCase(int numberCase) {
        super.setNumberCase(numberCase);
    }
}
