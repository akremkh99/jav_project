package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.ZooFullException;

public class Zoo {
    private static final int MAX_ANIMALS = 3; // ✅ Nombre réduit pour le test
    private Animal[] animals;
    private int animalCount;
    private String name;
    private String city;

    public Zoo(String name, String city) {
        setName(name);
        this.city = city;
        this.animalCount = 0;
        this.animals = new Animal[MAX_ANIMALS];
    }

    public void addAnimal(Animal animal) throws ZooFullException {
        if (animalCount >= MAX_ANIMALS) {
            throw new ZooFullException("❌ Le zoo est plein, impossible d'ajouter " + animal.getName());
        }
        animals[animalCount++] = animal;
        System.out.println("✅ Animal ajouté : " + animal.getName() + " | Nombre total : " + animalCount);
    }

    public void displayAnimals() {
        System.out.println("🐾 Animaux du zoo " + name + " :");
        if (animalCount == 0) {
            System.out.println("Aucun animal dans le zoo.");
        } else {
            for (int i = 0; i < animalCount; i++) {
                System.out.println(animals[i]);
            }
        }
    }

    @Override
    public String toString() {
        return "🏛 Zoo { Nom: " + name + ", Ville: " + city + ", Nombre d'animaux: " + animalCount + " }";
    }
}
