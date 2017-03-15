package entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by N33na on 02.03.2017.
 */
public class Fox extends Hero{

    public Fox (){
        hp = 120;
        flirtChance = 0.7;
        attackPower = 15;
        // TODO: throw sprites into img directory
        imageView = new ImageView();
    }

    @Override
    public String attack(Hero hero) {
        return null;
    }

    @Override
    public void heal() { /* Fox can't heal itself */ }

    @Override
    public void giveUp() {
        System.out.println("fox gives up!");
    }
}
