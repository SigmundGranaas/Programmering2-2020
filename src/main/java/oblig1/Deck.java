package oblig1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Deck {

    private ArrayList<Card> kortstokk;
    private char[] suits = {'S', 'H', 'C', 'D'};

    public Deck(){
        kortstokk = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 13; j++) {
               kortstokk.add(new Card(suits[i], j+1) );
            }
        }
    }

    public ArrayList<Card> getKortstokk() {
        return kortstokk;
    }

    public ArrayList<Card> assign(int n){
        ArrayList<Card> assigned = new ArrayList<>();
        Collections.shuffle(getKortstokk());
        for (int i = 0; i < n; i++) {
            assigned.add(getKortstokk().get(i));
        }
        return assigned;
    }

    public static void main(String[] args) {
        Deck dekk = new Deck();
        //dekk.assign(14).stream().forEach(p -> System.out.println(p.getFace() + ", " + p.getSuit()));
        //dekk.getKortstokk().stream().filter(p -> p.getSuit() == 'S').forEach(p -> System.out.println(p.toString()));
        //List<Card> heart = dekk.getKortstokk().stream().filter(p -> p.getSuit() == 'H').collect(Collectors.toList());
        //heart.forEach(p -> System.out.println(p.toString()));
        //dekk.getKortstokk().stream().map(Card::getSuit).forEach(p -> System.out.println(p.toString()));
        //System.out.println(dekk.getKortstokk().stream().map(Card::getFace).reduce(Integer::sum).get());
        //System.out.println(dekk.assign(33).stream().anyMatch(p -> p.getFace() == 12 && p.getSuit() == 'S'));

        ArrayList<Card> suffle = dekk.assign(10);
        System.out.println(suffle.stream().map(Card::getSuit).collect(Collectors.toMap(p -> p, p -> 1 , (nyKort, sum) -> nyKort + sum)).values().stream().anyMatch(p -> p > 4));
        System.out.println(suffle.stream().map(Card::getSuit).collect(Collectors.groupingBy(e -> e, Collectors.counting())));

    }

}





      /*  a) Lag en klasse Deck som oppretter en fullstendig kort-stokk (52 kort)
        b) Lag en metode «assign» i Deck som plukker tilfeldig n kort fra kortstokket og returnerer disse
        i en Collection. «n» er et tall mellom 1 og 52 som sendes inn som parameter til assign
        funksjonen.
        c) Skriv et uttrykk med filter og forEach som skriver ut alle spar-kort (suit = 'S').
        d) Skriv et uttrykk med filter og collect som samler alle hjerter-kort (suit = 'H') i en ny liste.
        e) Skriv et uttrykk med map som gir en ny list med kortenes kortfarge.
        f) Skriv et uttrykk med reduce som gir summen av kortverdiene (face).
        g) Skriv et uttrykk med anyMatch som sier om spar dame finnes i lista.
        h) Skriv et uttrykk som sier om lista er en poker-flush, dvs. har fem kort hvor alle har samme
        kortfarge. */
