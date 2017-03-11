package entities;

/**
 * Created by N33na on 02.03.2017.
 */
public abstract class Hero {

    protected int hp;
    protected boolean isActive = false;

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }

    void attack(Hero hero) {
        System.out.println("Hero attacks");
    }
    void heal(){
        System.out.println("Hero heals himself");
    }
    void flirt(Hero hero){
        System.out.println("Hero flirts with some chance");
    }
    void giveUp(){
        System.out.println("Hero gives up, his enemy wins");
    }

}
