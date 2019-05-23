package warriors.engine;

abstract public class Cases {
  //  private String typeCase;
    protected String nameCase;
 //   private int numberCase;
    protected String res;

    /**
     * @param nameCase
     */
    public Cases (String nameCase) {
        this.nameCase = nameCase;
    }

    /**
     * @return
     */
    public String getNameCase() {
        return nameCase;
    }

    /**
     * @param hero
     *
     * Centralisation of every applyTreatment
     */
    public abstract void applyTreatment(Personnage hero);

    public void setNameCase(String nameCase) {
        this.nameCase = nameCase;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return " Case : " + getNameCase() + "\n";
    }
}

