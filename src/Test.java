import java.io.IOException;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        Management test = new Management();
        test.initialCreation();
        System.out.println(test.market.searchGame("Blood Rage").getName());
        Game cd_game = (Game) test.market.searchGame("Blood Rage").clone();
        System.out.println(cd_game.getName());
        cd_game.setName("Kasim Gokmenn");
        System.out.println("-------------------");
        System.out.println(test.market.searchGame("Blood Rage").getName());
        System.out.println(cd_game.getName());

        //test.login("ncandn","");
        //System.out.println(test.social.getUserMap().get("ncandn").getPassword());

    }
}
