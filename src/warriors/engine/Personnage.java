package warriors.engine;

import warriors.contracts.Hero;

abstract public class Personnage implements Hero, Cloneable {

    protected String name;
    protected String image;
    protected int life;
    protected int attackLevel;

    /**
     * @param name
     * @param image
     * @param life
     * @param attackLevel
     */
    public Personnage(String name, String image, int life, int attackLevel) {
        this.name = name;
        this.image = image;
        this.life = life;
        this.attackLevel = attackLevel;
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    @Override
    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return
     */
    @Override
    public int getLife() {
        return this.life;
    }

    /**
     * @param life
     */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     * @param newAtk
     */
    abstract public void addAtk(int newAtk);

    /**
     * @param newLife
     */
    abstract public void addLife(int newLife);

    /**
     * @return
     */
    @Override
    public int getAttackLevel() {
        return this.attackLevel;
    }

    /**
     * @param attackLevel
     */
    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }


    /**
     * @return
     */
    @Override
    public String toString() {
        return "\n" + "Stat du Hero : " + "\n" + "Nom : " + getName() + "\n" + "Vie : " + getLife() + "\n" + "attaque : " + getAttackLevel();
    }

    @Override
    public Object clone()
        throws CloneNotSupportedException
        {
            return super.clone();
        }

}
