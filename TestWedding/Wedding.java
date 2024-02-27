import java.time.LocalDate;

public class Wedding {
    private Couple couple;
    private LocalDate weddingDate;
    private String location;

    // constructor
    public Wedding(Couple couple, LocalDate weddingDate, String location) {
        this.couple = couple;
        this.weddingDate = weddingDate;
        this.location = location;
    }

    // get methods
    public Couple getCouple() {
        return couple;
    }

    public LocalDate getWeddingDate() {
        return weddingDate;
    }

    public String getLocation() {
        return location;
    }
}
