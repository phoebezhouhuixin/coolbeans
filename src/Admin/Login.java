package Admin;

import java.util.Scanner;

public class Login {
    Scanner sc1 = new Scanner (System.in);
    /**
     * Object level references for username and password.
     */
    private String username, password;

    /**
     * Constructor for Login class.
     * @param username initialises object level username
     * @param password initialises object level password
     */
    public void Admin(String username, String password){
        this.username = username;
        this.password = password;
    }
    /**
     * Sets username from system user, after prompting them for it
     */
    public void setusername(){
        System.out.println("Please enter username: ");
        this.username = sc1.nextLine(); // takes in newline, therefore no need to clear input buffer
    }
    /**
     * Sets password from system user, after prompting them for it 
     */
    public void setpassword(){
        System.out.println("Please enter password: ");
        this.password = sc1.nextLine(); // takes in newline, therefore no need to clear input buffer
    }
    /**
     * Getter for the current user's username
     * @return
     */
    public String getusername(){
        return this.username;
    }
    /**
     * Getter for the current user's password
     * @return
     */
    public String getpassword(){
        return this.password;
    }

}
