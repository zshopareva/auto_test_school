package io.zshopareva;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class WebDriverTest {

    @Test
    public  void test(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://auto.ru");
        webDriver.findElement(By.
                xpath("//a[contains(., 'Объявления')and contains(@class,'Link ServiceNavigation__link')]")).click();
        assertThat(webDriver.getCurrentUrl(), containsString("https://auto.ru/sankt-peterburg/cars/all/"));

        webDriver.quit();
    }
}
