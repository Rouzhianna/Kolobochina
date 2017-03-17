package entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by N33na on 02.03.2017.
 */
public class Fox extends Hero{

    public Fox (){
        super();
        allHp = 120;
        hp = allHp;
        flirtChance = 0.7;
        attackPower = 10;

        desc = "Fair spring came and melted the fox's house, while the hare's stood firm and strong.";
    }

    @Override
    public String attack(Hero hero) {
        return null;
    }

    @Override
    public boolean heal() { return false; }

    @Override
    public void giveUp() {
        System.out.println("fox gives up!");
    }
}
