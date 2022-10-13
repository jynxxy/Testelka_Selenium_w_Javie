import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class NavigationAndClosing {

    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //  driver.manage().window().setSize(new Dimension(1280, 720));
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void driverQuit() {
        driver.quit();
    }

    @Test
    public void getMethod() {
        driver.get("https://google.pl");
        driver.get("https://www.amazon.pl");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
}
