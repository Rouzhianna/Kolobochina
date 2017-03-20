package Client.entities;

/**
 * Created by N33na on 14.03.2017.
 */
public class Rabbit extends Hero {
    public Rabbit() {
        super();
        allHp = 100;
        hp = allHp;
        flirtChance = 0.5;
        attackPower = 10;
        healCoolDown = 2;
        desc = "Little rabbit from the forest.\nHe isn't very flirty and not very strong, but has more hp than our " +
                "round friend.";
    }

}
