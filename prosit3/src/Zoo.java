class Zoo {
    private static final int MAX_ANIMALS = 25; // Nombre maximum d’animaux
    private Animal[] animals;
    private int animalCount;
    private String name;
    private String city;

    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        this.animalCount = 0;
        this.animals = new Animal[MAX_ANIMALS]; // Taille fixe du tableau
    }

    // ✅ Méthode pour ajouter un animal
    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("❌ Le zoo est plein, impossible d'ajouter " + animal.name);
            return false;
        }
        if (searchAnimal(animal) != -1) {
            System.out.println("❌ L'animal " + animal.name + " existe déjà dans le zoo.");
            return false;
        }
        animals[animalCount] = animal;
        animalCount++;
        return true;
    }

    // ✅ Méthode pour rechercher un animal par son nom
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].name.equals(animal.name)) {
                return i;
            }
        }
        return -1;
    }

    // ✅ Méthode pour afficher les animaux du zoo
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

    // ✅ Méthode pour supprimer un animal
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            System.out.println("❌ L'animal " + animal.name + " n'existe pas dans le zoo.");
            return false;
        }
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1]; // Décalage des éléments
        }
        animals[animalCount - 1] = null; // Suppression effective
        animalCount--;
        return true;
    }

    // ✅ Vérifier si le zoo est plein
    public boolean isZooFull() {
        return animalCount >= MAX_ANIMALS;
    }

    // ✅ Comparer deux zoos et retourner celui avec le plus d'animaux
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        return (z1.animalCount >= z2.animalCount) ? z1 : z2;
    }

    @Override
    public String toString() {
        return "🏛 Zoo { Nom: " + name + ", Ville: " + city + ", Nombre d'animaux: " + animalCount + " }";
    }

    public void displayZoo() {
    }
}
