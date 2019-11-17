package General;

public enum StatusEnum {

    COMING_SOON("Coming soon"),
    PREVIEW("Preview"),
    NOW_SHOWING("Now Showing"),
    END_SHOWING("End of showing");

    private String s;

    /**
     * Sets the current object's showing status
     * @param s tone of the 4 types of showing status: Coming Soon, Preview, Now showing and End of showing
     */
    StatusEnum(String s) {
        this.s = s;
    }
    
    /**
     * Returns the current object's Showing status
     */
    public String toString() {
        return this.s;
    }
}