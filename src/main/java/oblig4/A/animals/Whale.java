package oblig4.A.animals;

import oblig4.A.Interfaces.Jumpable;
import oblig4.A.Interfaces.Swimmable;

public class Whale extends Mammal implements Jumpable, Swimmable {
    public Whale(String name, int code) {
        super(name, code);
    }

    @Override
    public void jump() {
        System.out.println(name + " jump");
    }

    @Override
    public void swim() {
        System.out.println(name + " swim");
    }
}
