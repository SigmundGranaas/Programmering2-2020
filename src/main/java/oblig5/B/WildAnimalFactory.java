package oblig5.B;

import java.time.LocalDate;

public class WildAnimalFactory  {
    private static WildAnimalFactory wildAnimalFactory = null;

    public static WildAnimalFactory getInstance() {
        if(wildAnimalFactory == null){
            wildAnimalFactory = new WildAnimalFactory();
        }
        return wildAnimalFactory;
    }

    public ScandinavianWildAnimal newMaleBear(String norName,
                                              String latName,
                                              String latFamily,
                                              LocalDate arrivalDate,
                                              String name,
                                              LocalDate dateOfBirth,
                                              boolean isDangerous,
                                              String address){
        return new MaleIndividual("Bjon", "Ursus arctos", "Ursidae", arrivalDate,name , dateOfBirth, isDangerous, address);
    }
    public ScandinavianWildAnimal newFemaleWolf(LocalDate arrivalDate,
                                                String name,
                                                LocalDate dateOfBirth,
                                                boolean isDangerous,
                                                String address,
                                                int noLitters){
        return new FemaleIndividual("Ulv","Canis Lupus","Canidae", arrivalDate, name, dateOfBirth, isDangerous, address, noLitters);
    }
    public ScandinavianWildAnimal newMaleWolf(LocalDate arrivalDate,
                                              String name,
                                              LocalDate dateOfBirth,
                                              boolean isDangerous,
                                              String address){
        return new MaleIndividual("Ulv","Canis Lupus","Canidae",  arrivalDate,name, dateOfBirth, isDangerous, address);
    }
}
