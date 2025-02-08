class Animal {
    String family;
    String name;
    int age;
    boolean isMammal;

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }

    public void displayAnimal() {
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "Animal { Nom: " + name + ", Famille: "
                + family + ", Age: " + age + ", Mammifere: "
                + (isMammal ? "Oui" : "Non") + " }";
    }
}