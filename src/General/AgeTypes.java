package General;

public enum AgeTypes {

    CHILD("Child"),
    STUDENT("Student"),
    SENIOR("Senior"),
    ADULT("Adult");
    private String ageName;
 
    AgeTypes(String ageName) {
        this.ageName = ageName;
    }
    /**
     * Returns the agename among: Child, Student, Senior and Adult to accordingly compute the ticket price
     * @return the age type
     */
    public String getAgeName() {
        return this.ageName;
    }
}