package warriors.engine;

abstract public class Cases {
  //  private String typeCase;
    protected String nameCase;
 //   private int numberCase;
    protected String res;

    public Cases (String nameCase) {
        this.nameCase = nameCase;
    }

//    public String getTypeCase() {
//        return typeCase;
//    }
//
//    public void setTypeCase(String typeCase) {
//        this.typeCase = typeCase;
//    }

    public String getNameCase() {
        return nameCase;
    }

    public abstract void applyTreatment(Personnage hero);

    public void setNameCase(String nameCase) {
        this.nameCase = nameCase;
    }
//
//    public int getNumberCase() {
//        return numberCase;
//    }
//
//    public void setNumberCase(int numberCase) {
//        this.numberCase = numberCase;
//    }


    @Override
    public String toString() {
        return " Case : " + getNameCase() + "\n";
    }
}

