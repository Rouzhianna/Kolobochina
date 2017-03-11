import entities.Fabrics.HeroFabric;
import entities.Hero;

import java.util.Scanner;

/**
 * Created by N33na on 02.03.2017.
 */
public class Kolobochina {

    public static void main(String[] args) {

    }

    private static Hero chooseSmbd(String role){
        System.out.println("Choose your " + role + "!");
        System.out.println("Kolobok\nFox");
        Scanner sc = new Scanner(System.in);
        Hero player = HeroFabric.createAHero(sc.next());
        while (player == null)
            System.out.println("Try again!");
        return null;
    }

}
