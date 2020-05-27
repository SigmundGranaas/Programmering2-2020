package oblig4.A.animals;

import oblig4.A.Interfaces.Flyable;

public class Bat extends Mammal implements Flyable {
    public Bat(String name, int code) {
        super(name, code);
    }

    @Override
    public void fly() {
        System.out.println(name + " fly");
    }
}
