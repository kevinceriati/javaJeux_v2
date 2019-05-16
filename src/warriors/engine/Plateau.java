package warriors.engine;
import warriors.contracts.Map;

public class Plateau implements Map {
String name;
int numberOfCase;

public Plateau(String name, int numberOfCase){
    this.name = name;
    this.numberOfCase = numberOfCase;
}
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getNumberOfCase() {
        return 0;
    }
    public void setNumberOfCase(int numberOfCase) {
        this.numberOfCase = numberOfCase;
    }
}
