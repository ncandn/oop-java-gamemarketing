import java.util.HashMap;

public class Social implements ISocial {

    private HashMap<String, User> userMap;

    public Social() {
        this.userMap = new HashMap<String, User>();
    }

    @Override
    public void addFriend(String username, String target_username) {

        User active_user = userMap.get(username);
        User target_user = userMap.get(target_username);
        if (target_user == null) {
            System.out.println("There is no user named " + target_username);
        }
        else {

            if (active_user.getFriendlist().contains(target_user))
                System.out.println("User is already your friend");
            else
                active_user.getFriendlist().add(target_user);
        }

    }

    @Override
    public void removeFriend(String username, String target_username) {

        User active_user = userMap.get(username);
        User target_user = userMap.get(target_username);
        if (target_user == null) {
            System.out.println("There is no user named " + target_username);
        } else {

            if (!(active_user.getFriendlist().contains(target_user)))
                System.out.println("User is not your friend");
            else {
                active_user.getFriendlist().remove(target_user);
                System.out.println("You are no longer friends with " + target_user.getUser_name());
            }

        }

    }

    @Override
    public void displayFriend(String username) {

        User active_user = userMap.get(username);
        for (User friends : active_user.getFriendlist())
            System.out.println(friends.getUser_name());
    }

    @Override
    public void sendRequest(String username, String target_username) {

        User active_user = userMap.get(username);
        User target_user = userMap.get(target_username);
        if (target_user == null)
            System.out.println("There is no user named " + target_username);
        else {
            
            if (active_user.getFriendlist().contains(target_user))
                System.out.println("User is already your friend");
            else if (active_user.getPending_request().contains(target_user))
                System.out.println("User is already your friend");
            else {
                active_user.getPending_request().add(target_user);
                System.out.println("Friend request sent");
            }
        }


    }

    public HashMap<String, User> getUserMap() {
        return userMap;
    }
}
