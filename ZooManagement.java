public class ZooManagement {
    public static void main(String[] args) {
        Animal lion = new Animal("Felins", "Lion", 5, true);
        Animal elephant = new Animal("Elephantides", "Elephant", 10, true);
        Animal crocodile = new Animal("Reptiles", "Crocodile", 3, false);
        Zoo myZoo = new Zoo("Belvedere", "Tunis", 25);

        myZoo.displayZoo();
        lion.displayAnimal();
        elephant.displayAnimal();
        crocodile.displayAnimal();
    }
}