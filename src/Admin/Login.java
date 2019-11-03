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
        this.username = sc1.nextLine(); // takes in newline, therefore no need to clear input buffer
    }
    public void setpassword(){
        System.out.println("Please enter password: ");
        this.password = sc1.nextLine(); // takes in newline, therefore no need to clear input buffer
    }
    public String getusername(){
        return this.username;
    }
    public String getpassword(){
        return this.password;
    }

}
