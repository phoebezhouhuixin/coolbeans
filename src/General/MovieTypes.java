package General;

public enum MovieTypes {

    TWOD("2D"),
    THREED("3D"),
    BLOCKBUSTER("Blockbuster");
    private String movieTypeName;
 
    MovieTypes(String movieTypeName) {
        this.movieTypeName = movieTypeName;
    }
    public String getMovieTypeName() {
        return this.movieTypeName;
    }
}