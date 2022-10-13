package Homework_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZamykaniePrzegladarkiISesji {

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
        driver.close();
        driver.quit();
    }

    @Test
    public void navigationTest() {
        driver.get("https://pl.wikipedia.org/wiki/Wikipedia:Strona_główna");
        driver.get("https://www.nasa.gov");
        driver.navigate().back();
        Assertions.assertEquals("Wikipedia, wolna encyklopedia", driver.getTitle());
        driver.navigate().forward();
        Assertions.assertEquals("NASA", driver.getTitle());
    }
}
