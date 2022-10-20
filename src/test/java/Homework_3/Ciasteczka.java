package Homework_3;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Ciasteczka {

    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));
        //driver.manage().window().setPosition(new Point(1000, 0));
        // driver.manage().window().maximize();

       // Assertions.assertEquals(7, driver.manage().getCookies().size(), "Number of cookies is not what expected");
    }

    @AfterEach
    public void driverQuit() {
    //    driver.close();
        driver.quit();
    }

    @Test
    public void checkingCookies() throws InterruptedException {
        String urlPL = "https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna";
        driver.navigate().to(urlPL);
        Thread.sleep(3000);
      //1.
        int numberOfCookies = driver.manage().getCookies().size();
        System.out.println(numberOfCookies);
        Assertions.assertEquals(numberOfCookies, driver.manage().getCookies().size());
      //2.
        Cookie cookie = new Cookie("test_cookie", "test_value");
        driver.manage().addCookie(cookie);
        Assertions.assertNotNull(driver.manage().getCookieNamed("test_cookie"), "That cookie doesn't exist");
      //3.
        driver.manage().getCookieNamed("test_cookie");
        Assertions.assertEquals("test_cookie", cookie.getName());
      //4.
        driver.manage().deleteCookie(cookie);
        Assertions.assertNull(driver.manage().getCookieNamed("test_cookie"), "This cookie exist");
      //5.
        driver.manage().deleteCookieNamed("PHP_ENGINE");
        Assertions.assertNull(driver.manage().getCookieNamed("PHP_ENGINE"), "This cookie exist");
      //6.
        Cookie cookie2 = driver.manage().getCookieNamed("plwikimwuser-sessionId");
        Assertions.assertEquals("pl.wikipedia.org", driver.manage().getCookieNamed("plwikimwuser-sessionId").getDomain());
        Assertions.assertEquals("/", driver.manage().getCookieNamed("plwikimwuser-sessionId").getPath());
        Assertions.assertFalse(cookie2.isHttpOnly(), driver.manage().getCookieNamed("plwikimwuser-sessionId").getValue());
    }


}
