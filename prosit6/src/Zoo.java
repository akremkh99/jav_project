package tn.esprit.gestionzoo.entities;

public class Zoo {
    private static final int MAX_ANIMALS = 25;
    private static final int MAX_AQUATIC = 10;
    private Animal[] animals;
    private Aquatic[] aquaticAnimals;
    private int animalCount;
    private int aquaticCount;
    private String name;
    private String city;

    public Zoo(String name, String city) {
        setName(name);
        this.city = city;
        this.animalCount = 0;
        this.aquaticCount = 0;
        this.animals = new Animal[MAX_ANIMALS];
        this.aquaticAnimals = new Aquatic[MAX_AQUATIC];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("❌ Erreur : Le nom du zoo ne peut pas être vide.");
        } else {
            this.name = name;
        }
    }

    public String getCity() {
        return city;
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("❌ Le zoo est plein, impossible d'ajouter " + animal.getName());
            return false;
        }
        if (searchAnimal(animal) != -1) {
            System.out.println("❌ L'animal " + animal.getName() + " existe déjà dans le zoo.");
            return false;
        }
        animals[animalCount++] = animal;
        return true;
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
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

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            System.out.println("❌ L'animal " + animal.getName() + " n'existe pas dans le zoo.");
            return false;
        }
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        return true;
    }

    public boolean isZooFull() {
        return animalCount >= MAX_ANIMALS;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        return (z1.animalCount >= z2.animalCount) ? z1 : z2;
    }

    // ✅ Ajout d'un animal aquatique
    public void addAquaticAnimal(Aquatic aquatic) {
        if (aquaticCount >= MAX_AQUATIC) {
            System.out.println("❌ Le zoo ne peut pas contenir plus de 10 animaux aquatiques.");
            return;
        }
        aquaticAnimals[aquaticCount++] = aquatic;
    }

    // ✅ Affichage de swim() pour tous les aquatiques
    public void swimAll() {
        for (int i = 0; i < aquaticCount; i++) {
            aquaticAnimals[i].swim();
        }
    }

    // ✅ Trouver la profondeur max des pingouins
    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                float depth = ((Penguin) aquaticAnimals[i]).getSwimmingDepth();
                if (depth > maxDepth) maxDepth = depth;
            }
        }
        return maxDepth;
    }

    // ✅ Nombre de dauphins et pingouins
    public void displayNumberOfAquaticsByType() {
        int dolphinCount = 0, penguinCount = 0;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) dolphinCount++;
            else if (aquaticAnimals[i] instanceof Penguin) penguinCount++;
        }
        System.out.println("🐬 Dauphins: " + dolphinCount + " | 🐧 Pingouins: " + penguinCount);
    }

    @Override
    public String toString() {
        return "🏛 Zoo { Nom: " + name + ", Ville: " + city + ", Nombre d'animaux: " + animalCount + " }";
    }
}
