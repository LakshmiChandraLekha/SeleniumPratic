package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dropdown {
    WebDriver driver;
    @Test
    public void verifySelectedvaluefrmdrpdown() throws InterruptedException {

        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebElement drop = driver.findElement(By.cssSelector("select#dropdown"));
        Select dropdownlist = new Select(drop);
        dropdownlist.selectByVisibleText("Option 1");
        Thread.sleep(3000);
        String selectedoption = dropdownlist.getFirstSelectedOption().getText();
        System.out.println(selectedoption);
        dropdownlist.selectByVisibleText("Option 2");
        String selectedoption1 = dropdownlist.getFirstSelectedOption().getText();
        System.out.println(selectedoption1);
       Assert.assertEquals(selectedoption1,"Option 2");


    }
}
