import java.util.*;
public class Market implements IMarket{
    private List<Game> games;

    public Market(List<Game> games) {
        this.games = games;
    }

    @Override
    public String displayMarket() {
        return null;
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
}
