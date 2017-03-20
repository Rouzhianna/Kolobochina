package Client.entities;

/**
 * Created by N33na on 02.03.2017.
 */
public class Kolobok extends Hero {

    public Kolobok() {
        super();
        allHp = 100;
        hp = allHp;
        flirtChance = 0.9;
        attackPower = 14;
        healCoolDown = 2;
        desc = "Brave young hero, right from the russian \"pechka\".\nHas ordinary hp amount, ordinary " +
                "attack power, but very big chances to charm his opponent.";
    }

}
