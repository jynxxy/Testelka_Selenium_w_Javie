import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.GregorianCalendar;
import java.util.Set;

public class Manage {

    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().setSize(new Dimension(1280, 720));
        driver.manage().window().setPosition(new Point(1000, 0));
        // driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      //  Assertions.assertEquals(7, driver.manage().getCookies().size(), "Number of cookies is not what expected");
    }

    @AfterEach
    public void driverQuit() {
    //    driver.close();
        driver.quit();
    }

    @Test
    public void gettingAndDeletingCookies() {
        Cookie cookieSessionId = driver.manage().getCookieNamed("session-id");
        driver.manage().deleteCookieNamed("seassion-id");
        Assertions.assertEquals(6, driver.manage().getCookies().size(), "Number of cookies is not what expected");

        // sprawdzenie czy to, co podamy w parametrze jest lub nie jest nullem
        // asercja po refaktorze
        Assertions.assertNull(driver.manage().getCookieNamed("session-id"), "Number of cookies is not what expected");

        driver.manage().deleteAllCookies();
        Assertions.assertEquals(0, driver.manage().getCookies().size(), "Number of cookies is not what expected");
    }

    @Test
    public void addingCookies() {
        Cookie newCookie = new Cookie("test_cookie", "test_value", ".amazon.com", "/",
                new GregorianCalendar(2022,10,30).getTime(), true, true);
        driver.manage().addCookie(newCookie);

        // sprawdzenie czy to, co podamy w parametrze jest lub nie jest nullem
        // asercja po refaktorze
        Assertions.assertNotNull(driver.manage().getCookieNamed("test-cookie"), "Cookie doesn't exist");

        Assertions.assertEquals(8, driver.manage().getCookies().size(), "Number of cookies is not what expected");
        Cookie secondCookie = new Cookie("test_cookie2", "test_value2");
        driver.manage().addCookie(secondCookie);

        // sprawdzenie czy to, co podamy w parametrze jest lub nie jest nullem
        // asercja po refaktorze
        Assertions.assertNotNull(driver.manage().getCookieNamed("test-cookie2"), "Cookie doesn't exist.");

        Assertions.assertEquals(9, driver.manage().getCookies().size(), "Number of cookies is not what expected");
        driver.manage().deleteCookie(newCookie);

        // sprawdzenie czy to, co podamy w parametrze jest lub nie jest nullem
        // asercja po refaktorze
        Assertions.assertNotNull(driver.manage().getCookieNamed("test-cookie2"), "Cookie isn't deleted.");

        Assertions.assertEquals(8, driver.manage().getCookies().size(), "Number of cookies is not what expected");
    }

    @Test
    public void windowSettings() {
        Point position = driver.manage().window().getPosition();
        Assertions.assertEquals(new Point(1000, 0), position, "Position of the windows is now what expected");
        Dimension size = driver.manage().window().getSize();
        Assertions.assertEquals(new Dimension(1290, 730), size, "Size of the windows is now what expected");
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
    }
}
