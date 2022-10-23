package Homework_4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProsteLokatory {

    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1290, 730));
        driver.manage().window().setPosition(new Point(8, 30));
        driver.navigate().to("http://fakestore.testelka.pl/moje-konto");
    }

    @AfterEach
    public void closeAndQuit() {
        //    driver.close();
        driver.quit();
    }

    @Test
    public void searchingElements() {
      //szukajka w prawym górnym rogu
        driver.findElement(By.id("woocommerce-product-search-field-0"));
        driver.findElement(By.name("s"));
      //pole do wpisania nazwy użytkownika
        driver.findElement(By.id("username"));
        driver.findElement(By.name("username"));
      //pole do wpisania hasła
        driver.findElement(By.id("password"));
        driver.findElement(By.name("password"));
        driver.findElement(By.className("password-input"));
      //przycisk logowania
        driver.findElement(By.name("login"));
      //checkbox do zapamiętania hasła
        driver.findElement(By.name("rememberme"));
        driver.findElement(By.id("rememberme"));
      //link do odzyskiwania hasła
        driver.findElement(By.linkText("Nie pamiętasz hasła?"));
      //link do kategorii “Żeglarstwo”
        driver.findElement(By.linkText("Żeglarstwo"));

    }
}
