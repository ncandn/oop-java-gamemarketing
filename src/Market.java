import java.util.*;
public class Market implements IMarket{
    private List<Game> games;

    public Market() {

        this.games = new ArrayList<Game>();
    }


    @Override
    public String displayMarket() {

        String strlist = "";
        for (Game i:games){
            strlist += i.getName() + " " + i.getPrice() + "TL" +"\n";
        }

        return strlist;
    }

    @Override
    public String displayMarket(String genre) {
        return null;
    }

    @Override
    public String sortMarketPrice() {
        return null;
    }

    @Override
    public String sortMarketRating() {
        return null;
    }

    @Override
    public String sortMarketPurchaseCount() {
        return null;
    }

    @Override
    public String searchGame(String name) {
        return null;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public void addGame(Game game){
        games.add(game);
    }
}
