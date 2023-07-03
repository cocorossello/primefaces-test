package org.primefaces.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTest {


    @Test
    public void keyFilterTest() {
        WebDriverManager.chromedriver().setup();
        var driver = new ChromeDriver();
        driver.get("http://localhost:8080/primefaces-test/");
        driver.findElement(By.cssSelector(".some-input")).sendKeys("ج");
        System.out.printf(driver.findElement(By.cssSelector(".some-input")).getAttribute("value"));
    }
}
