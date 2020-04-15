public interface IMarket {
    String displayMarket();
    String displayMarket(String genre);
    String sortMarketPrice();
    String sortMarketRating();
    String sortMarketPurchaseCount();
    String searchGame(String name);
}
