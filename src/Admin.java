public class Admin extends Person{

    private String user_name;
    private String password;


    public Admin(String user_name, String password)
    {
        super();
        this.user_name = user_name;
        this.password = password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }
}
