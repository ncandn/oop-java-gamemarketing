import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Game> games;
    
    
    public Library() {
        this.games = new ArrayList<Game>();
    }

    public List<Game> getgames() {
        return games;
    }

    public String displayLibrary(){
        String output = "";
        for (Game i : games) {
            output += i.getName() + i.getStatus() +"\n" ;
        }

        return output;
    }

    public String displayLibrary(String genre) {
        String output = "";
        for (Game i : games) {
            if (i.getGenre().equals(genre)) {
                output += i.getName() + i.getStatus() +"\n";
            }
        }
        return output;
    }

    public void addGame(Game game) {

        if(!games.contains(game)) {
            games.add(game);
        }
        else
            System.out.println("This game is already in the library!");
    }

    public void removeGame(Game game) {
        if(games.contains(game))
            games.remove(game);

    }
}