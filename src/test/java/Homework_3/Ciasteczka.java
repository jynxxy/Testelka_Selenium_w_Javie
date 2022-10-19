package Homework_3;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver.close();
        driver.quit();
    }

    @Test
    public void checkingCookies() throws InterruptedException {
        String urlPL = "https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna";
        driver.navigate().to(urlPL);
        Thread.sleep(3000);
        int test = driver.manage().getCookies().size();
        System.out.println(test);
    }


}
