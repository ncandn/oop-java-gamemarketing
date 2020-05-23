import java.awt.EventQueue;
import java.io.IOException;

public class UserInterFace {

    public static void main(String[] args) throws CloneNotSupportedException, IOException {

    	EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginPage login = new LoginPage();
                    login.getLoginFrame().setLocationRelativeTo(null);
                    login.getLoginFrame().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
