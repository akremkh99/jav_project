class Zoo {
    Animal[] animals;
    String name;
    String city;
    int nbrCages;

    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
        this.animals = new Animal[25];
    }

    public void displayZoo() {
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "Zoo { Nom: " + name +", Ville: "
                + city + ", Nombre de cages: " + nbrCages + " }";
    }
}