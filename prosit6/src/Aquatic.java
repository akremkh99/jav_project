package tn.esprit.gestionzoo.entities;

public abstract class Aquatic extends Animal {
    private String habitat;

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public Aquatic() {
        super("Unknown", "Unknown", 0, false);
        this.habitat = "Unknown";
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    // ✅ Méthode abstraite pour forcer la redéfinition
    public abstract void swim();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aquatic aquatic = (Aquatic) obj;
        return getAge() == aquatic.getAge() && habitat.equals(aquatic.habitat) && getName().equals(aquatic.getName());
    }

    @Override
    public String toString() {
        return super.toString() + ", Habitat: " + habitat;
    }
}
