import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Management {
    private Admin admin = new Admin("admin","admin35");
    private Social social = new Social();
    private  Market market = new Market();
    private FileOperation fileOperation = new FileOperation();
 
   

	public Management() throws CloneNotSupportedException, IOException {

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


    //
    public void register(String user_name, String name, String lastname, String nickname, String password, String email, Address address,
                         Phone phone, Date birthdate) throws IOException {

        if (social.getUserMap().get(user_name) == null) {
            User new_user = new User(user_name, name, lastname,nickname, password, email, address, phone, birthdate);
            social.getUserMap().put(user_name, new_user);
            fileOperation.updateUser(social.getUserMap());
        } else {
            // WIP
        }
    }
    //wıp
    public int control()
    {
        return 0;
    }

    //wıp
    public void displayCommon()
    {
        for (HashMap.Entry<String, User> entry : social.getUserMap().entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    public void pageAdmin()
    {
        //market
            //addgame+
            //updategame+
            //removegame+
        //social
            //removeuser
            //display all user
    }

    public void pageClient()
    {
        //Social
            //addfriend+
            //removeFriend+
            //accept friend req+
            //display friend+
            //display comman
        //market
            // rent game+
            // purchased game+
            // shiping game
            // display market+
            // review game
        // library
            //display game+
            //remove game

    }
    public Admin getAdmin() {
		return admin;
	}

	public Social getSocial() {
		return social;
	}


	public Market getMarket() {
		return market;
	}





}
