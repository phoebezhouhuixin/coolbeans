package General;

public enum MovieTypes {

    TWOD("2D"),
    THREED("3D"),
    BLOCKBUSTER("Blockbuster");
    private String movieTypeName;
    /**
     * Sets the current object's movieType 
     * @param movieTypeName There are three movie types: 2D, 3D and Blockbuster
     */
    MovieTypes(String movieTypeName) {
        this.movieTypeName = movieTypeName;
    }
    /**
     * Returns the current objects' movie type
     * @return String value for movie type
     */
    public String getMovieTypeName() {
        return this.movieTypeName;
    }
}