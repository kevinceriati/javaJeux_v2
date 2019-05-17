package warriors.engine;

public class Cases {
    private String typeCase;
    private String nameCase;
    private int numberCase;

    public Cases (int numberCase, String typeCase, String nameCase) {
        this.nameCase = nameCase;
        this.numberCase = numberCase;
        this.typeCase = typeCase;
    }

    public String getTypeCase() {
        return typeCase;
    }

    public void setTypeCase(String typeCase) {
        this.typeCase = typeCase;
    }

    public String getNameCase() {
        return nameCase;
    }

    public void setNameCase(String nameCase) {
        this.nameCase = nameCase;
    }

    public int getNumberCase() {
        return numberCase;
    }

    public void setNumberCase(int numberCase) {
        this.numberCase = numberCase;
    }
}

