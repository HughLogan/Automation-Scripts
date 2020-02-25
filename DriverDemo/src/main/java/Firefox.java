import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {
    private static String userDir = System.getProperty("user.dir");
    public static void run() {

        System.setProperty("webdriver.gecko.driver", userDir + "/src/main/resources/geckodriver");
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://mars.nasa.gov/insight/");
        firefox.manage().window().maximize();
        firefox.quit();
        System.out.println();
    }
    public static void Winrun() {

        System.setProperty("webdriver.gecko.driver", userDir + "/src/main/resources/wingeckodriver.exe");
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://mars.nasa.gov/insight/");
        firefox.manage().window().maximize();
        firefox.quit();
        System.out.println();
    }
}
