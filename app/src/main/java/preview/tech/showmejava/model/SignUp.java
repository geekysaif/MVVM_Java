package preview.tech.showmejava.model;

public class SignUp  {

    private String Email;
    private String password;
    private String c_password;

    public SignUp(String email, String pass, String c_pass) {
        this.Email = email;
        this.password = pass;
        this.c_password = c_pass;

    }
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getC_password() {
        return c_password;
    }

    public void setC_password(String c_password) {
        this.c_password = c_password;
    }

}
