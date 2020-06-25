public class PersonFactory {

    public Person getPerson(String user_type, String user_name, String name,
                          String lastname, String nickname, String password,
                          String email, Address address, Phone phone, Date date){
        if(user_type.equalsIgnoreCase("USER")){
            return new User(user_name,name,lastname,nickname,password,email,address,phone,date);
        }
        else if(user_type.equalsIgnoreCase("ADMIN")){
            return new Admin(user_name,name,lastname,nickname,password,email,address,phone,date);
        }
        return null;
    }

}
