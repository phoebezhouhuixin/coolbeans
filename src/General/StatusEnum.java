package General;

public enum StatusEnum {

    COMING_SOON("Coming soon"),
    PREVIEW("Preview"),
    NOW_SHOWING("Now Showing"),
    END_SHOWING("End of showing");

    private String s;

    StatusEnum(String s) {
        this.s = s;
    }

    public String toString() {
        return this.s;
    }
}