package oblig4.A.animals;

import oblig4.A.Interfaces.Swimmable;
import oblig4.A.Interfaces.Walkable;

public class Crocodile extends Oviparous implements Swimmable, Walkable {
    public Crocodile(String name, int code) {
        super(name, code);
    }

    @Override
    public void swim() {
        System.out.println(name + " swim");
    }

    @Override
    public void walk() {
        System.out.println(name + " walk");
    }
}
