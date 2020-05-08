import java.io.IOException;

public class Management {

    // user counstragtında super ile person counstragtır çağrılıcak
    Social social = new Social();
    Market market = new Market();
    FileOperation fileOperation = new FileOperation();
    public void initialCreation() throws IOException {

        fileOperation.readMarket(market);
        fileOperation.readUser(social.getUserMap());
        fileOperation.readSocial(social.getUserMap());
        fileOperation.readLibrary(social.getUserMap(), market);
        System.out.println(market.displayMarket());
    }

   public void purchase()
   {}
   public void rent()
   {}
   public void login()
   {}
   public void register()
   {}




}
