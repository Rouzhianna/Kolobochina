package entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by N33na on 02.03.2017.
 */
public class Kolobok extends Hero {

    public Kolobok() {
        super();
        hp = 100;
        flirtChance = 0.9;
        attackPower = 15;
        desc = "Brave young hero, right from the russian \"pechka\".\nHas ordinary hp amount, ordinary " +
                "attack power, but very big chances to charm his opponent.";

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
