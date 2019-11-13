package General;

public enum AgeTypes {

    CHILD("Child"),
    STUDENT("Student"),
    SENIOR("Senior");
    private String ageName;
 
    AgeTypes(String ageName) {
        this.ageName = ageName;
    }
    public String getAgeName() {
        return this.ageName;
    }
}