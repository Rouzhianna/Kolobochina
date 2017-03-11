package entities.Fabrics;

import entities.Fox;
import entities.Hero;
import entities.Kolobok;

/**
 * Created by N33na on 02.03.2017.
 */
public class HeroFabric {

    public static Hero createAHero(String hero){
        if(hero.equalsIgnoreCase("fox"))
            return new Fox();
        else if(hero.equalsIgnoreCase("kolobok"))
            return new Kolobok();
        else
            return null;
    }

}
