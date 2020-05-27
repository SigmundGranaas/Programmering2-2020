package oblig4.A.animals;

import oblig4.A.Interfaces.Flyable;
import oblig4.A.Interfaces.Walkable;

public class Pelican extends Oviparous implements Flyable, Walkable {
    public Pelican(String name, int code) {
        super(name, code);
    }

    @Override
    public void fly() {
        System.out.println(name + " fly");
    }

    @Override
    public void walk() {
        System.out.println(name + " walk");
    }
}
