package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

public class ZooManagement {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo("Belvedere", "Tunis");

        Animal lion = new Animal("Felins", "Lion", 5, true);
        Animal elephant = new Animal("Elephantides", "Elephant", -2, true); // Test âge négatif
        Animal crocodile = new Animal("Reptiles", "Crocodile", 3, false);

        myZoo.addAnimal(lion);
        myZoo.addAnimal(elephant);
        myZoo.addAnimal(crocodile);

        myZoo.displayZoo();
        myZoo.displayAnimals();

        System.out.println("🔍 Recherche du lion : index " + myZoo.searchAnimal(lion));
        myZoo.removeAnimal(elephant);
        myZoo.displayAnimals();

        Zoo zoo2 = new Zoo("", "Hammamet"); // Test nom vide
        zoo2.addAnimal(new Animal("Felins", "Tigre", 4, true));

        Zoo largestZoo = Zoo.comparerZoo(myZoo, zoo2);
        System.out.println("🐘 Le zoo avec le plus d'animaux est : " + largestZoo);
    }
}
