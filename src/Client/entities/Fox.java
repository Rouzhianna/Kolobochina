package Client.entities;

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
        healCoolDown = 3;

        desc = "Beautiful and charming fox.\n" +
                "She has more hp than kolobok or rabbit,\n" +
                "But she isn't that strong, and she\n" +
                "restores her ability to heal very slow.";
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
