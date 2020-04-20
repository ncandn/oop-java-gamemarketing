import java.util.ArrayList;
import java.util.List;

public class User extends Person{
    static int ID;
    private String user_name;
    private String nickname;
    private Library library;
    public  List<User> friendlist;
    public  List<User> pending_request;

    public User(String user_name, String nickname, Library library) {
        this.user_name = user_name;
        this.nickname = nickname;
        this.library = library;
        this.friendlist = new ArrayList<User>();
        this.pending_request = new  ArrayList<User>();
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        User.ID = ID;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public List<User> getPending_request() {
        return pending_request;
    }

    public void setPending_request(ArrayList<User> pending_request) {
        this.pending_request = pending_request;
    }

    public List<User> getFriendlist() {
        return friendlist;
    }

    public void setFriendlist(User user) {
        this.friendlist = friendlist;
    }



}