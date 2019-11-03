package Admin;

import java.util.Scanner;

public class Login {
    private String username, password;
    Scanner sc1 = new Scanner (System.in);
    public void Admin(String username, String password){
        this.username = username;
        this.password = password;
    }
    public void setusername(){
        System.out.println("Please enter username: ");
        username = sc1.nextLine(); // takes in newline, therefore no need to clear input buffer
        this.username = username;
    }
    public void setpassword(){
        System.out.println("Please enter password: ");
        password = sc1.nextLine(); // takes in newline, therefore no need to clear input buffer
        this.password = password;
    }
    public String getusername(){
        return this.username;
    }
    public String getpassword(){
        return this.password;
    }

}
