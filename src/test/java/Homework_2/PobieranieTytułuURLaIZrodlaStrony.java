package Homework_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PobieranieTytułuURLaIZrodlaStrony {

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
    public void getURLTest() {
        String titleUrlPL = "Wikipedia, wolna encyklopedia";
        String urlPL = "https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna";
        String langPL = "lang=\"pl\"";
        driver.navigate().to("https://pl.wikipedia.org");
        Assertions.assertEquals(titleUrlPL, driver.getTitle());
        Assertions.assertEquals(urlPL, driver.getCurrentUrl());
        Assertions.assertTrue(driver.getPageSource().contains(langPL) , "Page source doesn't contain: "
                + langPL);
        driver.findElement(By.cssSelector("a[title='hiszpański']")).click();
        String titleUrlES = "Wikipedia, la enciclopedia libre";
        String urlES = "https://es.wikipedia.org/wiki/Wikipedia:Portada";
        String langES = "lang=\"es\"";
        Assertions.assertEquals(titleUrlES, driver.getTitle());
        Assertions.assertEquals(urlES, driver.getCurrentUrl());
        Assertions.assertTrue(driver.getPageSource().contains(langES), "Page source doesn't contain: " + langES);
    }
}
