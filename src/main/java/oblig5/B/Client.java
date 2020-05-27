package oblig5.B;

import java.time.LocalDate;
import java.util.logging.Logger;

public class Client {
    private static final Logger log = Logger.getLogger(Client.class.getName());


    public static void main(String[] args) {
        ScandinavianWildAnimal ulla = WildAnimalFactory.getInstance().newFemaleWolf(LocalDate.of(2015,2,26),"Ulla" , LocalDate.of(2015,4,29),true , "Innhegning 2, Skandinaviske rovdyr", 3);
    }
}
