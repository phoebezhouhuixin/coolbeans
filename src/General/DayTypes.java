package General;

public enum DayTypes {

    WEEKDAY("Weekday"),
    WEEKEND("Weekend"),
    HOLIDAY("Holiday");
    private String dayName;
    /**
     * Sets the current object's day type to the day types among: Weekday, Weekend and Holiday
     * @param dayName  There are three day types: Weekday, Weekend and Holiday
     */
    DayTypes(String dayName) {
        this.dayName = dayName;
    }
    /**
     * Returns the current day type
     * @return day type
     */
    public String getDayName() {
        return this.dayName;
    }
}