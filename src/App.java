import Framework.AppConfiguration;
import UserInterface.LoginGUI;

public class App {
    public static void main(String[] args) throws Exception {
        AppConfiguration.eaLoad("src/config.properties");
        new LoginGUI();
    }
}
