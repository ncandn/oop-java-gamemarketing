import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Management {

    Social social = new Social();
    Market market = new Market();
    FileOperation fileOperation = new FileOperation();

    public void initialCreation() throws CloneNotSupportedException, IOException {

        fileOperation.readMarket(market);
        fileOperation.readUser(social.getUserMap());
        fileOperation.readSocial(social.getUserMap());
        fileOperation.readLibrary(social.getUserMap(), market);
    }

    public void purchase(Game game, User user_name) throws CloneNotSupportedException {
        // Declaring the target user.
        User user = social.getUserMap().get(user_name);
        // Cloning the desired game from the market.
        Game cloned_game = (Game) game.clone();
        // For the game was purchased, setting the status according.
        cloned_game.setStatus("purchased");
        user.getLibrary().addGame(cloned_game);
    }

    public void rent(Game game, User user_name) throws CloneNotSupportedException {
        // Declaring the target user.
        User user = social.getUserMap().get(user_name);
        Game cloned_game = (Game) game.clone();
        cloned_game.setStatus("purchased");
        // Fetching the system date for renting calculations.
        // Formatting the date and converting it to the desired state.
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calobj = Calendar.getInstance();
        String[] formatted_date = df.format(calobj.getTime()).split("/");
        Date rent_date = new Date(Integer.valueOf(formatted_date[0]),Integer.valueOf(formatted_date[1]),
                Integer.valueOf(formatted_date[2]));
        // Cloning the game.
        cloned_game.setRent_date(rent_date);
        user.getLibrary().addGame(cloned_game);
    }

    public void login(String username, String password) {
        // WIP
        if (social.getUserMap().containsKey(username)) {
            if (social.getUserMap().get(username).getPassword().equals(password)) {
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                if (input.equals("1")) {
                    System.out.println("successful");
                    System.out.println(market.displayMarket());
                } else if (input.equals("2")) {
                    System.out.println("successful");

                    System.out.println(social.getUserMap().get(username).getLibrary().displayLibrary());
                }
            } else
                System.err.println("unexpected action 1");

        } else {
            System.err.println("unexpected action");
        }
    }

    //
    public void register(String user_name, String nickname, String password, String email, Address address,
                         Phone phone, Date birthdate) throws IOException {

        if (social.getUserMap().get(user_name) == null) {
            User new_user = new User(user_name, nickname, password, email, address, phone, birthdate);
            social.getUserMap().put(user_name, new_user);
            fileOperation.updateUser(social.getUserMap());
        } else {
            // WIP
        }
    }


}
