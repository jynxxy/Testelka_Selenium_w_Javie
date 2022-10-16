import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GettingURLSourceAndTitle {

    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));
      //  driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void driverQuit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void getCurrentURLExample() {
        String googleURL = "https://www.google.pl";
        String testelka = "https://testelka.pl/";
        driver.navigate().to("https://testelka.pl");
        Assertions.assertEquals(testelka, driver.getCurrentUrl(), "Current URL is not: " + testelka);
    }

    @Test
    public void getCurrentTitleExample() {
        String titleURL = "Zacznij automatyzować testy aplikacji webowych";
        driver.navigate().to("https://testelka.pl");
        Assertions.assertEquals(titleURL, driver.getTitle(), "Page title is not: " + titleURL);
    }

    @Test
    public void getSourceExample() {
        String testelkaImg = "https://testelka.pl/wp-content/uploads/ela-circle-front.png";
        driver.navigate().to("https://testelka.pl");
        Assertions.assertTrue(driver.getPageSource().contains(testelkaImg), "Page source does not contain: " + testelkaImg);
    }
}
