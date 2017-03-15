package entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by N33na on 14.03.2017.
 */
public class Rabbit extends Hero {
    public Rabbit() {
        hp = 80;
        flirtChance = 0.5;
        attackPower = 10;
        desc = "";
        frontWait = new Image("../gui/img/heroes/rabbit/rabbit_front_wait.png");
        backWait = new Image("../gui/img/heroes/rabbit/rabbit_back_wait.png");
        frontAttack = new Image("../gui/img/heroes/rabbit/rabbit_front_attack.png");
        backAttack = new Image("../gui/img/heroes/rabbit/rabbit_back_attack.png");
        frontDamage = new Image("../gui/img/heroes/rabbit/rabbit_front_damage.png");
        backDamage = new Image("../gui/img/heroes/rabbit/rabbit_back_damage.png");
        imageView = new ImageView();
    }

    @Override
    public String attack(Hero hero) {
        return super.attack(hero);
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
        System.out.println("Rabbit gives up!");
    }
}
