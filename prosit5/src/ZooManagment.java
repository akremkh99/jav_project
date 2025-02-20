package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class ZooManagement {
    public static void main(String[] args) {
        // ✅ Création du zoo
        Zoo myZoo = new Zoo("Belvedere", "Tunis");

        // ✅ Création d'animaux
        Animal lion = new Animal("Felins", "Lion", 5, true);
        Animal elephant = new Animal("Elephantides", "Elephant", 10, true);
        Animal crocodile = new Animal("Reptiles", "Crocodile", 3, false);

        // ✅ Ajout des animaux
        myZoo.addAnimal(lion);
        myZoo.addAnimal(elephant);
        myZoo.addAnimal(crocodile);

        // ✅ Affichage des animaux du zoo
        myZoo.displayZoo();
        myZoo.displayAnimals();

        // ✅ Recherche et suppression d'un animal
        System.out.println("🔍 Recherche du lion : index " + myZoo.searchAnimal(lion));
        myZoo.removeAnimal(elephant);
        myZoo.displayAnimals();

        // ✅ Comparaison de deux zoos
        Zoo zoo2 = new Zoo("Friguia", "Hammamet");
        zoo2.addAnimal(new Animal("Felins", "Tigre", 4, true));

        Zoo largestZoo = Zoo.comparerZoo(myZoo, zoo2);
        System.out.println("🐘 Le zoo avec le plus d'animaux est : " + largestZoo);

        // ✅ Création d'animaux aquatiques et terrestres
        Dolphin flipper = new Dolphin("Cetacea", "Flipper", 8, true, "Ocean", 25.5f);
        Penguin tux = new Penguin("Spheniscidae", "Tux", 5, false, "Antarctica", 15.0f);

        // ✅ Affichage des animaux aquatiques et terrestres
        System.out.println(flipper);
        System.out.println(tux);

        // ✅ Test du polymorphisme avec swim()
        Aquatic a1 = new Aquatic("Poisson", "Nemo", 2, false, "Mer");
        Dolphin d1 = new Dolphin("Cetacea", "Echo", 10, true, "Ocean", 30.0f);
        Penguin p1 = new Penguin("Spheniscidae", "Happy", 6, false, "Glacier", 20.0f);

        a1.swim(); // Affiche : "This aquatic animal is swimming."
        d1.swim(); // Affiche : "This dolphin is swimming."
        p1.swim(); // Affiche : "This aquatic animal is swimming."
    }
}
