package entities;

/**
 * Created by N33na on 02.03.2017.
 */
public class Fox extends Hero{

    public Fox (){
        hp = 120;
    }

    @Override
    public void attack(Hero hero) {
        System.out.println("fox attacks strongly");
    }
    @Override
    public void heal() { /* Fox can't heal itself */ }
    @Override
    public void flirt(Hero hero) {
        System.out.println("fox flirts with big chance");
    }
    @Override
    public void giveUp() {
        System.out.println("fox gives up, ");
    }
}
