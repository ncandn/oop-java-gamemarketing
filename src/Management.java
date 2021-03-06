import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Management {
    PersonFactory personFactory = new PersonFactory();
    private String addressstr = "izmir/izmir/izmir/izmir";
    private String phonestr = "+90/322/6542/gsm";
    private String datestr = "11/11/1111";
    private String[] add_temp = addressstr.split("/");
    private String[] phone_temp = phonestr.split("/");
    private String[] temp_date = datestr.split("/");
    private Address address = new Address(add_temp[0], add_temp[1], add_temp[2], add_temp[3]);
    private Phone phone = new Phone(phone_temp[0], phone_temp[1], phone_temp[2], phone_temp[3]);
    private Date admin_date = new Date(Integer.valueOf(temp_date[0]), Integer.valueOf(temp_date[1]), Integer.valueOf(temp_date[2]));
    private Person admin_factory = personFactory.getPerson("ADMIN", "admin", "admin","izmir",
             "ceo","admin35","admin35@gmail.com",address,
             phone,admin_date);
    private Admin admin = (Admin)admin_factory;
    private Social social = new Social();
    private Market market = Market.getMarket();
    private Shipping shipping = new Shipping();
    private FileOperation fileOperation = new FileOperation();
    private Person activeUser;


    public Person getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(Person activUser) {
		this.activeUser = activUser;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Management() throws CloneNotSupportedException, IOException {

        fileOperation.readMarket(market);
        fileOperation.readUser(social.getUserMap());
        fileOperation.readSocial(social.getUserMap());
        fileOperation.readLibrary(social.getUserMap(), market);
    }

    public void purchase(Game game) throws CloneNotSupportedException, IOException {
        // Declaring the target user.

        // Cloning the desired game from the market.
        Game cloned_game = (Game) game.clone();
        // For the game was purchased, setting the status according.
        cloned_game.setStatus("purchased");
        ((User) activeUser).getLibrary().addGame(cloned_game);
        fileOperation.updateLibrary(social.getUserMap());
        fileOperation.updateMarket(market);
    }

    public void rent(Game game , int rent) throws CloneNotSupportedException, IOException {
        // Declaring the target user
        Game cloned_game = (Game) game.clone();
        cloned_game.setStatus("rent");
        // Fetching the system date for renting calculations.
        // Formatting the date and converting it to the desired state.
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calobj = Calendar.getInstance();
        String[] formatted_date = df.format(calobj.getTime()).split("/");
        Date rent_date = new Date(Integer.valueOf(formatted_date[0]),Integer.valueOf(formatted_date[1]),
                Integer.valueOf(formatted_date[2]));
        // Cloning the game.
        cloned_game.setRent_date(rent_date);
        cloned_game.setRental_period(rent);
        ((User) activeUser).getLibrary().addGame(cloned_game);
        fileOperation.updateLibrary(social.getUserMap());
    }


    //
    public void register(String user_name, User user) throws IOException {

        if (social.getUserMap().get(user_name) == null) {

            social.getUserMap().put(user_name, user);
            fileOperation.updateUser(social.getUserMap());

        }
    }

    public void updateSocial() throws IOException, QueueEmpty{

    	fileOperation.updateSocial(social.getUserMap());

	}
    public void updateUser() throws IOException {
    	fileOperation.updateUser(social.getUserMap());

	}
    public void updatelibrary() throws IOException {
    	fileOperation.updateLibrary(social.getUserMap());

	}
    public void updateMarket() throws IOException {
    	fileOperation.updateMarket(market);
	}



    public int control()
    {
        return 0;
    }


    public void displayCommon()
    {
        for (HashMap.Entry<String, User> entry : social.getUserMap().entrySet()) {
            System.out.println(entry.getKey());
        }
    }


    public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
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