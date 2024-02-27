public class Couple {
    private Person bride;
    private Person groom;

    // constructor
    public Couple(Person bride, Person groom) {
        this.bride = bride;
        this.groom = groom;
    }

    // get methods
    public Person getBride() {
        return bride;
    }

    public Person getGroom() {
        return groom;
    }
}
