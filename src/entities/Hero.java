package entities;

import javafx.scene.image.ImageView;

import java.util.Random;

/**
 * Created by N33na on 02.03.2017.
 */
public abstract class Hero {

    protected int hp;
    protected double flirtChance;
    protected int attackPower;
    protected boolean isActive = false;
    // TODO: throw sprites into img directory
    protected ImageView imageView;

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
        Random random = new Random();
        double num = random.nextDouble();
        num = num - (num % 0.01);
        if(num >= flirtChance)
            System.out.println("This hero's flirt succeed");
    }
    void giveUp(){
        System.out.println("Hero gives up, his enemy wins");
    }

}
