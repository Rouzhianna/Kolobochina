package entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by N33na on 14.03.2017.
 */
public class Rabbit extends Hero {
    public Rabbit() {
        super();
        allHp = 120;
        hp = allHp;
        flirtChance = 0.5;
        attackPower = 10;
        desc = "Little rabbit from the forest.\nHe is'n very flirty and not very strong, but has more hp than our " +
                "round friend.";
    }

}
