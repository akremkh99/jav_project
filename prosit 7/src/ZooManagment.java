package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;
import tn.esprit.gestionzoo.exceptions.*;

public class ZooManagement {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo("Belvedere", "Tunis");

        try {
            // ✅ Création d'animaux avec gestion d'erreurs
            Animal lion = new Animal("Felins", "Lion", 5, true);
            Animal elephant = new Animal("Elephantides", "Elephant", -3, true); // 🚨 Âge négatif
            Animal crocodile = new Animal("Reptiles", "Crocodile", 3, false);

            // ✅ Ajout des animaux avec gestion d'erreurs
            try {
                myZoo.addAnimal(lion);
                myZoo.addAnimal(elephant); // 🚨 Devrait lever InvalidAgeException
                myZoo.addAnimal(crocodile);
                myZoo.addAnimal(new Animal("Felins", "Tigre", 4, true)); // 🚨 ZooFullException
            } catch (ZooFullException e) {
                System.out.println(e.getMessage());
            }

        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        // ✅ Affichage du zoo et des animaux
        myZoo.displayAnimals();
    }
}
