import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Game> games;
    Market obj_market;

    public Library() {
        this.games = new ArrayList<Game>();
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public String displayLibrary(){
        String output = "";
        for (int i = 0; i < games.size(); i++) {
            output += games.get(i).getName();
        }
        return output;
    }

    public String displayLibrary(String genre) {
        String output = "";
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getGenre().equals(genre)) {
                output += games.get(i).getName();
            }

        }
        return output;
    }

    public void addGame(Game game) {
        obj_market.displayMarket();
        if(obj_market.getGames().contains(game))
            games.add(game);
    }

    public void removeGame(Game game) {
        displayLibrary();
        if(games.contains(game))
            games.remove(game);
    }
}