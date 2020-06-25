public class Admin extends Person{

    private String user_name;
    private String nickname;



    public Admin(String user_name,String name,String lastname,String nickname,
                 String password, String email, Address address, Phone phone, Date date)
    {
        super(name, lastname,email,password,address,phone,date);
        this.user_name = user_name;
        this.nickname = nickname;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

}
