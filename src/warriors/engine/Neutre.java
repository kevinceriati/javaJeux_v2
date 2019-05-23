package warriors.engine;

import warriors.engine.Cases;
import warriors.engine.Personnage;

public class Neutre extends Cases {
    /**
     * @param nameCase
     */
    public Neutre(String nameCase) {
        super(nameCase);
    }

    /**
     * @param hero
     */
    @Override
    public void applyTreatment(Personnage hero) {
    }
}
