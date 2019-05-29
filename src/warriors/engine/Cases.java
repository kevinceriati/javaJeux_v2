package warriors.engine;

import java.util.ArrayList;

abstract public class Cases {
  //  private String typeCase;
    protected String nameCase;
 //   private int numberCase;
    protected String res;
//    protected ArrayList<String> armes = new ArrayList<>();
//    protected ArrayList<String> spells = new ArrayList<>();

    /**
     * @param nameCase
     */
    public Cases (String nameCase) {
//        armes.add("arc");
//        armes.add("epee");
//        armes.add("massue");
//        spells.add("boules de feu");
//        spells.add("eclair");
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

