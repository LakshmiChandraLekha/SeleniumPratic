package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment {

    WebDriver driver;
    @Test
    public void verifyErrormsg(){

        driver = new ChromeDriver();
        driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
         WebElement startmyfreetrailbtn = driver.findElement(By.xpath("//button[text()='start my free trial']"));
         startmyfreetrailbtn.click();
         WebElement firstnameerrormsg = driver.findElement(By.xpath("//input[starts-with(@id,'UserFirstName')]/following-sibling::span"));
        String Actualerrormsg = firstnameerrormsg.getText();
        String Expectederrormsg = "Enter your first name";
        Assert.assertEquals(Actualerrormsg,Expectederrormsg);











    }


}
