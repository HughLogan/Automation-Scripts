import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Safari {
    public static void run() {

    WebDriver safari = new SafariDriver();
        safari.get("https://mars.nasa.gov/insight/");
        safari.manage().window().maximize();
        safari.quit();
        System.out.println();
}
}
