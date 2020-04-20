import java.util.HashMap;

public class Social implements ISocial {

    private HashMap<String, User> userMap;

    public Social() {
        this.userMap = new HashMap<String, User>();
    }

    public void addFriend(String username, User user){

        User active_user = userMap.get(username);
        if(active_user.getFriendlist().contains(user))
            System.out.println("User is already your friend");
        else
            active_user.getFriendlist().add(user);
    }
    public void removeFriend(User user){

        User active_user = userMap.get(username);
        if(!(active_user.getFriendlist().contains(user)))
            System.out.println("User is not your friend");
        else
        {
            active_user.getFriendlist().remove(user);
            System.out.println("You are no longer friends with " + user.getUser_name());
        }

    }
    public void displayFriend(){

        User active_user = userMap.get(username);
        for(User friends : active_user.getFriendlist())
            System.out.println(friends.getUser_name());
    }
    public void sendRequest(User user){

        User active_user = userMap.get(username);
        if(userMap.get(user) == null)
            System.out.println("There is no user named " + user.getUser_name());
        else if(active_user.getFriendlist().contains(user))
            System.out.println("User is already your friend");
        else if (active_user.getPending_request().contains(user))
            System.out.println("User is already your friend");
        else
        {
            active_user.getPending_request().add(user);
            System.out.println("Friend request sent");
        }

    }
    public HashMap<String, User> getUserMap() {
        return userMap;
    }
}
