import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class FileOperation {


    public void readMarket(Market market) throws IOException
    {

       try
       {
           File file = new File("games.csv");
           Scanner scn = new Scanner(file);
           scn.nextLine();
           while (scn.hasNext())
           {
               String[] line = (scn.nextLine()).split(";");
               String[] date_temp = line[8].split(",");
               Date date = new Date(Integer.valueOf(date_temp[0]),Integer.valueOf(date_temp[1]),Integer.valueOf(date_temp[2]));
               Game game = new Game(line[0],line[1],line[2],Integer.valueOf(line[3]),Integer.valueOf(line[4]),
                       Integer.valueOf(line[5]), Double.valueOf(line[6]),Double.valueOf(line[7]),date);

               market.addGame(game);
           }
           scn.close();
       }
       catch (FileNotFoundException e)
       {
           FileWriter file = new FileWriter("games.csv");
           file.write("NAME;DESCRIPTION;GENRE;PURCHASE_COUNT;STOCK;AGE_LIMIT;PRICE;RATING;RELEASE_DATE\n");
           file.close();
       }
    }
    public void readUser(HashMap<String, User> userMap) throws IOException {
        try
        {
            File file = new File("users.csv");
            Scanner scn = new Scanner(file);
            scn.nextLine();
            while (scn.hasNext())
            {
                String[] line = (scn.nextLine()).split(";");
                String[] add_temp = line[4].split("/");
                String[] phone_temp = line[5].split("/");
                String[] temp_date = line[6].split("/");
                Address address = new Address(add_temp[0], add_temp[1], add_temp[2], add_temp[3]);
                Phone phone = new Phone(phone_temp[0], phone_temp[1], phone_temp[2], phone_temp[3]);
                Date date = new Date(Integer.valueOf(temp_date[0]), Integer.valueOf(temp_date[1]), Integer.valueOf(temp_date[2]));
                User user = new User(line[0], line[1], line[2], line[3], address, phone, date);

            }
            scn.close();
        }
        catch (FileNotFoundException e)
        {
            FileWriter file = new FileWriter("users.csv");
            file.write("USERNAME;NICKNAME;PASSWORD;EMAIL;ADDRESS;PHONE;BIRTHDATE\n");
            file.close();
        }

    }
    public void readLibrary(HashMap<String, User> userMap, Market market) throws IOException {
        try
        {
            File file = new File("library.csv");
            Scanner scn = new Scanner(file);
            scn.nextLine();
            while (scn.hasNext())
            {
                String[] line = (scn.nextLine()).split(";");
                for(Game game : market.getGames())
                {
                    if(game.getName().equalsIgnoreCase(line[1]))
                    {
                        userMap.get(line[0]).getLibrary().getGames().add(game);
                    }
                }
            }
            scn.close();
        }
        catch (FileNotFoundException e)
        {
            FileWriter file = new FileWriter("library.csv");
            file.write("USER_NAME;GAME\n");
            file.close();
        }
    }
    public void readSocial(HashMap<String, User> userMap) throws IOException {
        try
        {
            File file = new File("social.csv");
            Scanner scn = new Scanner(file);
            scn.nextLine();
            while (scn.hasNext())
            {
                String[] line = (scn.nextLine()).split(";",-1);

                if(line[1] != null)
                {
                    String[] friend_list = line[1].split(",");
                    for (String user : friend_list)
                    {
                        userMap.get(line[0]).getFriendlist().add(userMap.get(user));
                    }
                }
                if(line[2] != null)
                {
                    String[] requests = line[2].split(",");
                    for (String user : requests)
                    {
                        userMap.get(line[0]).getPending_request().enqueue(userMap.get(user));
                    }
                }
            }
            scn.close();
        }
        catch (FileNotFoundException e)
        {
            FileWriter file = new FileWriter("social.csv");
            file.write("USER_NAME;GAME\n");
            file.close();
        }
    }
    public void appendGame(Game game)  throws IOException
    {
        FileWriter file_writer = new FileWriter("games.csv");
        file_writer.write(game.getName() + ";" + game.getDescription() + ";" + game.getGenre() + ";" + game.getPurchase_count() +
                ";" + game.getStock() + ";" + game.getAge_limit() + ";" + game.getPrice() + ";" + game.getRating() + ";" + game.getRelease_date() + "\n");

        file_writer.close();
    }
    public void appendGame(Game game, String username) throws IOException { // update game for library file

        FileWriter file_writer = new FileWriter("library.csv");
        file_writer.write(username + ";" + game.getName() + "\n");
        file_writer.close();

    }

    public void updateMarket(Market market) throws IOException {


        FileWriter file_writer = new FileWriter("games.csv", false);
        for (Game game : market.getGames())
        {
            file_writer.write(game.getName() + ";" + game.getDescription() + ";" + game.getGenre() + ";" + game.getPurchase_count() +
                    ";" + game.getStock() + ";" + game.getAge_limit() + ";" + game.getPrice() + ";" + game.getRating() + ";" + game.getRelease_date() + "\n");
        }
    }
    public void updateUser(HashMap<String, User> userMap) throws IOException {

        FileWriter file_writer = new FileWriter("users.csv", false);
        for (HashMap.Entry<String, User> entry : userMap.entrySet())
        {
            User user = entry.getValue();
            String addres = user.getAddress().getStreetname() + "/" + user.getAddress().getTown() + "/" + user.getAddress().getCity() + "/" + user.getAddress().getCountry();
            String phone = user.getPhone().getCountrycode() + "/" + user.getPhone().getCode() + "/" + user.getPhone().getNumber() + "/" + user.getPhone().getType();
            String birth_date = user.getBirthDate().getDay() + "/" + user.getBirthDate().getMonth() + "/" + user.getBirthDate().getYear();
            file_writer.write(user.getUser_name() + ";" + user.getNickname() + ";" + user.getPassword()
            + ";" + user.getEmail() + ";" + addres + ";" + phone+ ";" + birth_date);
        }

    }
    public void updateSocial(HashMap<String, User> userMap) throws IOException, QueueEmpty {

        FileWriter file = new FileWriter("social.csv");
        for (HashMap.Entry<String, User> entry : userMap.entrySet())
        {
            String line = entry.getKey() + ";";
            int size = entry.getValue().getFriendlist().size();
            for ( int i = 0; i < size - 1 ; i++)
                line += entry.getValue().getFriendlist().get(i).getUser_name() + ",";
            line += entry.getValue().getFriendlist().get(size - 1).getUser_name() + ";";


            size = entry.getValue().getPending_request().size();
            for (int i = 0; i < size - 1; i++)
            {
                line += entry.getValue().getPending_request().peek().getUser_name() + ",";
                entry.getValue().getPending_request().enqueue(entry.getValue().getPending_request().dequeue());
            }
            line += entry.getValue().getPending_request().peek().getUser_name();
            entry.getValue().getPending_request().enqueue(entry.getValue().getPending_request().dequeue());
        }
    }

}



