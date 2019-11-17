package General;

public abstract class ViewableWithAuth {
    /**
     * Some data should only be viewed if the user has the correct credentials.Specify the contract by implementing this function.
     * @param filename
     * @param username username for authentication
     * @param password password for authentication
     */
    public abstract void displayAll(String filename, String username, String password);
}
