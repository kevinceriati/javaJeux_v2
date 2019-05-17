package warriors.engine;
import warriors.contracts.Map;
import java.util.ArrayList;

public class Plateau implements Map {
String name;
int numberOfCase;
private ArrayList<Cases> casesList = new ArrayList<>();

public Plateau(String name, int numberOfCase){
    this.name = name;
    this.numberOfCase = numberOfCase;
    createCase();
}
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getNumberOfCase() {
        return 0;
    }

    public ArrayList<Cases> getCasesList() {
        return casesList;
    }

    public void setNumberOfCase(int numberOfCase) {
        this.numberOfCase = numberOfCase;
    }

    public void createCase () {
        for (int j = 0; j < 64; j++) {
            if (j == 45 || j == 52 || j == 56 || j == 62) {
                 Cases cases = new Cases(j, "Dragon !", "Ennemi !");
                casesList.add(cases);

            } else if (j == 10 || j == 20 || j == 25 || j == 32 || j == 35 || j == 36 || j ==37 || j == 40 || j == 44 || j == 47) {
                Cases cases = new Cases(j, "Sorcier ! !", "Ennemi !");
                casesList.add(cases);

            } else if (j == 3 || j == 6 || j == 9 || j == 12 || j == 15 || j == 18 || j == 21 || j == 24 || j ==27 || j ==30){
                Cases cases = new Cases(j, " Gobelin !", "Ennemi !");
                casesList.add(cases);

                ////CASE SURPRISES/////

            } else if (j == 2 || j == 11 || j == 14 || j == 19 || j == 26){
                Cases cases = new Cases(j, " Vous avez trouvé un arc !","Surprise !");
                casesList.add(cases);

            } else if (j == 5 || j == 22 || j == 38){
                Cases cases = new Cases(j, " Vous avez trouvé une massue !", "Surprise !");
                casesList.add(cases);

            } else if (j == 42 || j == 53){
                Cases cases = new Cases(j, " Vous avez trouvé une épée !", "Surprise !");
                casesList.add(cases);

            } else if (j == 1 || j == 4 || j == 8 || j == 17 || j == 23){
                Cases cases = new Cases(j, " Vous avez trouvé un éclair !","Surprise !");
                casesList.add(cases);

            } else if (j == 48 || j == 49){
                Cases cases = new Cases(j, " Vous avez trouvé une boule de feu !", "Surprise !");
                casesList.add(cases);

            } else if (j == 7 || j == 13 || j == 28 || j == 29 || j == 33){
                Cases cases = new Cases(j, " Vous avez trouvé une potion mineure !","Surprise !");
                casesList.add(cases);

            } else if (j == 31 || j == 39 || j == 43){
                Cases cases = new Cases(j, " Vous avez trouvé une potion standard !", "Surprise !");
                casesList.add(cases);

            }  else if (j == 41){
                Cases cases = new Cases(j, " Vous avez trouvé une grande potion !","Surprise !");
                casesList.add(cases);

            }  else {
                Cases cases = new Cases(j, " Vous êtes sur une case vide !","Neutre !");
                casesList.add(cases);
            }
        }
    }
}
