import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {
    private static String userDir = System.getProperty("user.dir");
    public static void run() {

        System.setProperty("webdriver.chrome.driver", userDir + "/src/main/resources/chromedriver");
        WebDriver chrome = new ChromeDriver();
        chrome.get("https://mars.nasa.gov/insight/");
        chrome.manage().window().maximize();
        chrome.quit();
        System.out.println();
    }
        public static void Winrun() {

            System.setProperty("webdriver.chrome.driver", userDir + "/src/main/resources/winchromedriver.exe");
            WebDriver winChrome = new ChromeDriver();
            winChrome.get("https://mars.nasa.gov/insight/");
            winChrome.manage().window().maximize();
            winChrome.quit();
            System.out.println();
        }
    }

