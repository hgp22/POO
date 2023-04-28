package Model;

import java.io.Serializable;

public class Login implements Serializable {
    private String password;
    private String email;

    public Login() {
        this.email = "";
        this.password = "";
    }

    public Login(String email,String password) {
        this.email = email;
        this.password = password;
    }

    public Login(Login l) {
        this.email = l.getEmail();
        this.password = l.getPassword();
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setNome(String email) {
        this.email = email;
    }

    public Login clone() {
        return new Login(this);
    }

    @Override
    public String toString() {
        return "Login{" +
                ", Email: '" + email + '\'' +
                ", Password:'" + password + '\'' +
                '}';
    }
}
