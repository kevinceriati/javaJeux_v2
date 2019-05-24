package warriors.engine;
import warriors.contracts.Map;
import java.util.ArrayList;

public class Plateau implements Map {
String name;
int numberOfCase;
private ArrayList<Cases> casesList = new ArrayList<>();

    /**
     * @param name
     * @param numberOfCase
     */
public Plateau(String name, int numberOfCase){
    this.name = name;
    this.numberOfCase = numberOfCase;
    createCase();
}

    /**
     * @return
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * @return
     */
    @Override
    public int getNumberOfCase() {
        return numberOfCase;
    }

    public void setNumberOfCase(int numberOfCase) {
        this.numberOfCase = numberOfCase;
    }

    /**
     * @return
     */
    public ArrayList<Cases> getCasesList() {
        return casesList;
    }

    /**
     * Board creation
     */
    public void createCase () {
        for (int j = 0; j < 64; j++) {
            if (j == 45 || j == 52 || j == 56 || j == 62) {
                     Cases dragon = new Ennemi("dragon", 15, 4);
                casesList.add(dragon);

            } else if (j == 10 || j == 20 || j == 25 || j == 32 || j == 35 || j == 36 || j ==37 || j == 40 || j == 44 || j == 47) {
                Cases sorcier = new Ennemi("sorcier", 9, 2);
                casesList.add(sorcier);

            } else if (j == 3 || j == 6 || j == 9 || j == 12 || j == 15 || j == 18 || j == 21 || j == 24 || j ==27 || j ==30){
                Cases gobelins = new Ennemi("gobelin", 6, 1);
                casesList.add(gobelins);

                ////CASE SURPRISES/////

            } else if (j == 2 || j == 11 || j == 14 || j == 19 || j == 26){
                Cases arc = new Arme("arc", 1);
                casesList.add(arc);

            } else if (j == 5 || j == 22 || j == 38){
                Cases massue = new Arme("massue", 3);
                casesList.add(massue);

            } else if (j == 42 || j == 53){
                Cases epee = new Arme("epee", 5);
                casesList.add(epee);

            } else if (j == 1 || j == 4 || j == 8 || j == 17 || j == 23){
                Cases eclair = new Arme("eclair", 2);
                casesList.add(eclair);

            } else if (j == 48 || j == 49){
                    Cases boulesDeFeu = new Arme("boules de feu", 7);
                casesList.add(boulesDeFeu);

            } else if (j == 7 || j == 13 || j == 28 || j == 29 || j == 33){
                Cases potionMineure = new Potion( "potion Mineur", 1);
                casesList.add(potionMineure);

            } else if (j == 31 || j == 39 || j == 43){
                    Cases potionStandard = new Potion("potion standard", 2);
                casesList.add(potionStandard);

            }  else if (j == 41){
                Cases potionGrande = new Potion("potion grande", 5);
                casesList.add(potionGrande);

            }  else {
                Cases cases = new Neutre("neutre");
                casesList.add(cases);
            }
        }
    }
}
