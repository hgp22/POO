package Model;

import java.io.Serializable;

public class Login implements Serializable {
    private String password;
    private String username;

    public Login() {
        this.username = "";
        this.password = "";
    }

    public Login(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public Login(Login l) {
        this.username = l.getUsername();
        this.password = l.getPassword();
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setNome(String username) {
        this.username = username;
    }

    public Login clone() {
        return new Login(this);
    }

    @Override
    public String toString() {
        return "Login{" +
                ", Username: '" + username + '\'' +
                ", Password:'" + password + '\'' +
                '}';
    }
}
