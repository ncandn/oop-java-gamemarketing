public interface IMarket {
    String displayMarket();
    String displayMarket(String genre);
    String sortMarketPrice();
    String sortMarketRating();
    String sortMarketPurchaseCount();
    Game searchGame(String name);
    void addGame(Game game);
}
