package entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

/**
 * Created by N33na on 02.03.2017.
 */
public abstract class Hero {

    protected int hp;
    protected static int allHp = 1;
    protected double flirtChance;
    protected int attackPower;

    protected String desc;

    protected Image frontWait;
    protected Image backWait;
    protected Image frontDamage;
    protected Image backDamage;
    protected Image frontAttack;
    protected Image backAttack;
    protected ImageView imageView;
    protected boolean isActive = false;

    private String heroName;
    public String getHeroName(){return heroName;}

    protected Hero(){
        heroName = getClass().getSimpleName().toLowerCase();
        addImages();
    }

    public int getHp() { return hp; }
    public int getAllHp() {return allHp;}

    public int getAttackPower() { return attackPower; }

    public void setHp(int hp) { this.hp = hp; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) {
        isActive = active;
    }

    public String attack(Hero hero) {
        System.out.println("Hero attacks");
        return null;
    }

    public void heal(){ System.out.println("Hero heals himself"); }

    public boolean flirt(){
        Random random = new Random();
        double num = random.nextDouble();
        num = num - (num % 0.01);
        if(num >= flirtChance)
            return true;
        return false;
    }

    public void giveUp(){
        System.out.println("Hero gives up, his enemy wins");
    }

    //get-setters
    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    protected void addImages() {
        frontWait =   new Image(getClass().getResource("../gui/img/heroes/" + heroName + "/" + heroName +"_front_wait.png").toExternalForm());
        backWait =    new Image(getClass().getResource("../gui/img/heroes/" + heroName + "/" + heroName +"_back_wait.png").toExternalForm());
        frontAttack = new Image(getClass().getResource("../gui/img/heroes/" + heroName + "/" + heroName +"_front_attack.png").toExternalForm());
        backAttack =  new Image(getClass().getResource("../gui/img/heroes/" + heroName + "/" + heroName +"_back_attack.png").toExternalForm());
        frontDamage = new Image(getClass().getResource("../gui/img/heroes/" + heroName + "/" + heroName +"_front_damage.png").toExternalForm());
        backDamage =  new Image(getClass().getResource("../gui/img/heroes/" + heroName + "/" + heroName +"_back_damage.png").toExternalForm());
        imageView = new ImageView(frontWait);
    }

    public Image getFrontWait() { return frontWait; }
    public Image getBackWait() { return backWait; }
    public Image getFrontDamage() { return frontDamage; }
    public Image getBackDamage() { return backDamage; }
    public Image getFrontAttack() { return frontAttack; }
    public Image getBackAttack() { return backAttack; }
}
