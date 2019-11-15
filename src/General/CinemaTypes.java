package General;

public enum CinemaTypes {

    SILVER("Silver"),
    GOLD("Gold"),
    PLATINUM("Platinum");

    private String cinemaTypeName;
    /**
     * Sets the current object's cinema type to the cinema type among: Silver, Gold and Platinum
     * @param cinemaTypeName There are three cinema types: Gold, Silver and Platinum
     */

    CinemaTypes(String cinemaTypeName) {
        this.cinemaTypeName = cinemaTypeName;
    }
    /**
     * Returns the cinema type among : Gold, Silver and Platinum
     * @return the cinema Type
     */
    public String getCinemaTypeName() {
        return this.cinemaTypeName;
    }
}