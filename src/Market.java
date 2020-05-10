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
        String strlist = "";
        for (Game i:games){
            if (i.getGenre().equals(genre)) {
                strlist += i.getName() + " " + i.getPrice() + "TL" + "\n";
            }
        }

        return strlist;
    }

    @Override
    public String sortMarketPrice() {
        games.sort(Comparator.comparing(Game::getPrice));
        String strlist = "";
        for (Game i:games){
            strlist += i.getName() + " " + i.getPrice() + "TL" + "\n";
        }
        return strlist;
    }

    @Override
    public String sortMarketRating() {
        games.sort(Comparator.comparing(Game::getRating));
        String strlist = "";
        for (Game i:games){
            strlist += i.getName() + " " + i.getRating() + "*" + "\n";
        }
        return strlist;
    }

    @Override
    public String sortMarketPurchaseCount() {
        games.sort(Comparator.comparing(Game::getPurchase_count));
        String strlist = "";
        for (Game i:games){
            strlist += i.getName() + " " + i.getPurchase_count() + " users have bought this game." + "\n";
        }
        return strlist;
    }

    @Override
    public Game searchGame(String name) {
        for(Game i : games){
            if (i.getName().equals(name))
                return i;
        }
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
