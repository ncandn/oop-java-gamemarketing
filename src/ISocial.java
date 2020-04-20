import java.util.HashMap;

public interface ISocial {

    public void addFriend(String username, User user);
    public void removeFriend(User user);
    public void displayFriend();
    public void sendRequest(User user);
    public HashMap<String, User> getUserMap() ;
}
