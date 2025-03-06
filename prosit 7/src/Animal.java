package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.InvalidAgeException;

public class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    public Animal(String family, String name, int age, boolean isMammal) throws InvalidAgeException {
        this.family = family;
        this.name = name;
        setAge(age); // Vérification de l'âge via setAge()
        this.isMammal = isMammal;
    }

    public Animal() throws InvalidAgeException {
        this("Unknown", "Unknown", 0, false);
    }

    public String getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("❌ Erreur : L'âge d'un animal ne peut pas être négatif.");
        }
        this.age = age;
    }

    public boolean isMammal() {
        return isMammal;
    }

    public void displayAnimal() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Animal { Nom: " + name + ", Famille: " + family + ", Âge: " + age + ", Mammifère: " + (isMammal ? "Oui" : "Non") + " }";
    }
}
