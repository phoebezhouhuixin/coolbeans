package General;

public enum CinemaTypes {

    SILVER("Silver"),
    GOLD("Gold"),
    PLATINUM("Platinum");

    private String cinemaTypeName;

    CinemaTypes(String cinemaTypeName) {
        this.cinemaTypeName = cinemaTypeName;
    }
    public String getCinemaTypeName() {
        return this.cinemaTypeName;
    }
}