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
        healCoolDown = 1;
        desc = "Little rabbit from the forest.\n" +
                "He isn't very flirty and not very strong,\n" +
                "but has more hp than our round friend.\n" +
                "And he can heal himself frequently.";
    }

}
