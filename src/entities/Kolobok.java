package entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by N33na on 02.03.2017.
 */
public class Kolobok extends Hero {

    public Kolobok() {
        hp = 100;
        flirtChance = 0.9;
        attackPower = 15;
        desc = "Brave young hero, right from the russian \"pechka\".\nHas ordinary hp amount, ordinary " +
                "attack power, but very big chances to charm his opponent.";
        /*frontWait = new Image("../gui/img/heroes/kolobok/kolobok_front_wait.png");
        backWait = new Image("../gui/img/heroes/kolobok/kolobok_back_wait.png");
        frontAttack = new Image("../gui/img/heroes/kolobok/kolobok_front_attack.png");
        backAttack = new Image("../gui/img/heroes/kolobok/kolobok_back_attack.png");
        frontDamage = new Image("../gui/img/heroes/kolobok/kolobok_front_damage.png");
        backDamage = new Image("../gui/img/heroes/kolobok/kolobok_back_damage.png");*/
        imageView = new ImageView();
    }

    @Override
    public String attack(Hero hero) {
        return null;
    }

    @Override
    public void heal() {
        super.heal();
    }

    @Override
    public void flirt(Hero hero) {
        super.flirt(hero);
    }

    @Override
    public void giveUp() {
        System.out.println("kol gives up!");
    }
}
