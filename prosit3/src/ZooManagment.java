public class ZooManagement {
    public static void main(String[] args) {
        // ✅ Création du zoo
        Zoo myZoo = new Zoo("Belvedere", "Tunis");

        // ✅ Création des animaux
        Animal lion = new Animal("Felins", "Lion", 5, true);
        Animal elephant = new Animal("Elephantides", "Elephant", 10, true);
        Animal crocodile = new Animal("Reptiles", "Crocodile", 3, false);

        // ✅ Ajout des animaux
        myZoo.addAnimal(lion);
        myZoo.addAnimal(elephant);
        myZoo.addAnimal(crocodile);
        myZoo.addAnimal(lion); // Test ajout d'un animal déjà existant

        // ✅ Affichage du zoo et des animaux
        myZoo.displayZoo();
        myZoo.displayAnimals();

        // ✅ Recherche d'un animal
        System.out.println("🔍 Recherche du lion : index " + myZoo.searchAnimal(lion));
        System.out.println("🔍 Recherche d’un panda (absent) : index " + myZoo.searchAnimal(new Animal("Ursidae", "Panda", 7, true)));

        // ✅ Suppression d’un animal
        myZoo.removeAnimal(elephant);
        myZoo.displayAnimals();

        // ✅ Test du zoo plein
        for (int i = 0; i < 23; i++) {
            myZoo.addAnimal(new Animal("Divers", "Animal" + i, i, false));
        }
        System.out.println("Le zoo est-il plein ? " + myZoo.isZooFull());

        // ✅ Comparaison de zoos
        Zoo zoo2 = new Zoo("Friguia", "Hammamet");
        zoo2.addAnimal(new Animal("Felins", "Tigre", 4, true));

        Zoo largestZoo = Zoo.comparerZoo(myZoo, zoo2);
        System.out.println("🐘 Le zoo avec le plus d'animaux est : " + largestZoo);
    }
}
