package entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by N33na on 02.03.2017.
 */
public class Fox extends Hero{

    public Fox (){
        hp = 120;
        flirtChance = 1;
        attackPower = 5;
        // TODO: throw sprites into img directory
        imageView = new ImageView(new Image(""));
    }

    @Override
    public void attack(Hero hero) {
        System.out.println("fox attacks strongly");
    }

    @Override
    public void heal() { /* Fox can't heal itself */ }

    @Override
    public void giveUp() {
        System.out.println("fox gives up, ");
    }
}
