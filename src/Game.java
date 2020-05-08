public class Game {
    private String name, description;
    private String genre;
    private int purchase_count, stock, age_limit;
    private double price, rating;
    private Date release_date;

    public Game(String name, String description, String genre,int purchase_count ,int stock, int age_limit, double price,
                double rating, Date release_date) {
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.stock = stock;
        this.age_limit = age_limit;
        this.price = price;
        this.release_date = release_date;
        this.purchase_count = purchase_count;
        this.rating = rating;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPurchase_count() {
        return purchase_count;
    }

    public void setPurchase_count(int purchase_count) {
        this.purchase_count = purchase_count;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getAge_limit() {
        return age_limit;
    }

    public void setAge_limit(int age_limit) {
        this.age_limit = age_limit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

}
