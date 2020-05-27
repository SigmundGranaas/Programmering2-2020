package oblig4.A;

import oblig4.A.Interfaces.Flyable;
import oblig4.A.Interfaces.Jumpable;
import oblig4.A.Interfaces.Walkable;
import oblig4.A.animals.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ZooClient {
    public static void main(String[] args) throws ZooException {

        Zoo zoo = new Zoo("Kristiansand Dyrepark");

        Collection<Animal> animals = new ArrayList<Animal>();

        animals.add(new Crocodile("Crocodylus niloticus", 1001));
        animals.add(new Crocodile("Crocodylus niloticus", 1002));
        animals.add(new Crocodile("Crocodylus porosus", 1101));
        animals.add(new Crocodile("Crocodylus porosus", 1102));
        animals.add(new Pelican("Brown Pelican  ", 4001));
        animals.add(new Pelican("Dalmatian Pelican  ", 4101));


        animals.add(new Whale("Blue whale", 2001));
        animals.add(new Whale("Blue whale", 2002));
        animals.add(new Whale("Minke whale", 2101));
        animals.add(new Whale("Minke whale", 2102));
        animals.add(new Bat("Acerodon ", 3001));
        animals.add(new Bat("Cistugo  ", 3002));

        animals.stream().filter(e -> e instanceof Flyable).forEach(e -> ((Flyable) e).fly());
        animals.stream().filter(e -> e instanceof Jumpable && e instanceof Mammal).forEach(e -> ((Jumpable) e).jump());

        zoo.setAnimals(animals);
        List<Object> walker = zoo
                .getAnimals()
                .stream()
                .filter(e -> e instanceof Walkable)
        .collect(Collectors.toList());

        try {
            walker.stream().forEach(e -> {((Flyable) e).fly();});
        } catch (ClassCastException e) {
            throw new ZooException("YEET", e);
        }

    }
}