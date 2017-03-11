package entities;

/**
 * Created by N33na on 02.03.2017.
 */
public class Kolobok extends Hero {

    public Kolobok() {
        hp = 100;
    }

    @Override
    void attack(Hero hero) {
        super.attack(hero);
    }

    @Override
    void heal() {
        super.heal();
    }

    @Override
    void flirt(Hero hero) {
        super.flirt(hero);
    }

    @Override
    void giveUp() {
        super.giveUp();
    }
}
