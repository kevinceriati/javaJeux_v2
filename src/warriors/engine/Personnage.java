package warriors.engine;

import warriors.contracts.Hero;

public class Personnage implements Hero {

    protected String name;
    protected String image;
    protected int life;
    protected int attackLevel;

    public Personnage (String name, String image, int life, int attackLevel) {
        this.name = name;
        this.image = image;
        this.life = life;
        this.attackLevel = attackLevel;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
       this.image = image;
    }

    @Override
    public int getLife() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public int getAttackLevel() {
        return this.attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }
}
