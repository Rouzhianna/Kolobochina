package Client.entities.Fabrics;

import Client.entities.Fox;
import Client.entities.Hero;
import Client.entities.Kolobok;
import Client.entities.Rabbit;

/**
 * Created by N33na on 02.03.2017.
 */
public class HeroFabric {

    public static Hero createAHero(String hero){
        if(hero.equalsIgnoreCase("fox"))
            return new Fox();
        else if(hero.equalsIgnoreCase("kolobok"))
            return new Kolobok();
        else if (hero.equalsIgnoreCase("rabbit"))
            return new Rabbit();
        return null;
    }

}
