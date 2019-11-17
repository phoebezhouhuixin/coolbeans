package General;

public abstract class ViewableWithAuth {
    // Some data should only be viewed if the user has the correct credentials.
    // Specify the contract
    public abstract void displayAll(String filename, String username, String password);
}
