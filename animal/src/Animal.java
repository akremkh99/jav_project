package tn.esprit.gestionzoo.entities;

public class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        setAge(age); // Sécuriser l'âge
        this.isMammal = isMammal;
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

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("❌ Erreur : L'âge d'un animal ne peut pas être négatif.");
        } else {
            this.age = age;
        }
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
