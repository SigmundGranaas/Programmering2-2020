package oblig3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Tribune tribune1 = new Stand("trib1", 64, 10);
        Tribune tribune2 = new Stand("trib2", 32, 7);
        Tribune tribune3 = new Sit("trib3", 24, 11);
        Tribune tribune4 = new VIP("trib4", 12, 5000);
        String[] names = {"peter","peter","peter","peter","peter"};

        Tribune[] tribunes = {tribune1, tribune2, tribune3, tribune4};

        tribune1.buyTicket(46);
        tribune2.buyTicket(60);
        tribune3.buyTicket(5, names);

        Arrays.stream(tribune4.buyTicket(3, names)).forEach(e -> System.out.println(e.toString()));

        Arrays.stream(tribunes).forEach(e -> System.out.println(e.toString()));
    }
}
