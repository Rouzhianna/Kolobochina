package entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by N33na on 14.03.2017.
 */
public class Rabbit extends Hero {
    public Rabbit() {
        super();
        hp = 80;
        flirtChance = 0.5;
        attackPower = 10;
        desc = "I'm rabbit";
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
