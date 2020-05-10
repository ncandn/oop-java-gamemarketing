import java.util.HashMap;

public interface ISocial {

    public void addFriend(String username, String target_username);
    public void removeFriend(String username, String target_username);
    public void displayFriend(String username);
    public void sendRequest(String username, String target_username);
    public HashMap<String, User> getUserMap() ;
}
