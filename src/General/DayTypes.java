package General;

public enum DayTypes {

    WEEKDAY("Weekday"),
    WEEKEND("Weekend"),
    HOLIDAY("Holiday");
    private String dayName;

    DayTypes(String dayName) {
        this.dayName = dayName;
    }
    public String getDayName() {
        return this.dayName;
    }
}