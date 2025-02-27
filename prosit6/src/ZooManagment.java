package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class ZooManagement {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo("Belvedere", "Tunis");

        // ✅ Création d'animaux normaux
        Animal lion = new Animal("Felins", "Lion", 5, true);
        Animal elephant = new Animal("Elephantides", "Elephant", 10, true);
        Animal crocodile = new Animal("Reptiles", "Crocodile", 3, false);

        // ✅ Ajout des animaux normaux
        myZoo.addAnimal(lion);
        myZoo.addAnimal(elephant);
        myZoo.addAnimal(crocodile);

        // ✅ Création d'animaux aquatiques
        Dolphin flipper = new Dolphin("Cetacea", "Flipper", 8, true, "Ocean", 25.5f);
        Penguin tux = new Penguin("Spheniscidae", "Tux", 5, false, "Antarctica", 15.0f);
        Penguin pingu = new Penguin("Spheniscidae", "Pingu", 7, false, "Antarctica", 20.0f);

        myZoo.addAquaticAnimal(flipper);
        myZoo.addAquaticAnimal(tux);
        myZoo.addAquaticAnimal(pingu);

        // ✅ Affichage du zoo
        myZoo.displayZoo();
        myZoo.displayAnimals();

        // ✅ Test affichage de swim()
        System.out.println("🌊 Test des animaux aquatiques nageant :");
        myZoo.swimAll();

        // ✅ Test profondeur max des pingouins
        System.out.println("🐧 Profondeur max des pingouins: " + myZoo.maxPenguinSwimmingDepth() + " m");

        // ✅ Test affichage du nombre de dauphins et pingouins
        myZoo.displayNumberOfAquaticsByType();

        // ✅ Recherche et suppression d'un animal
        System.out.println("🔍 Recherche du lion : index " + myZoo.searchAnimal(lion));
        myZoo.removeAnimal(elephant);
        myZoo.displayAnimals();

        // ✅ Comparaison de deux zoos
        Zoo zoo2 = new Zoo("Friguia", "Hammamet");
        zoo2.addAnimal(new Animal("Felins", "Tigre", 4, true));

        Zoo largestZoo = Zoo.comparerZoo(myZoo, zoo2);
        System.out.println("🐘 Le zoo avec le plus d'animaux est : " + largestZoo);
    }
}
