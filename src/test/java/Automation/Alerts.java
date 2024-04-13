package Automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts {
    WebDriver driver;
    @Test
    public void handleJavascriptalerts(){

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement alertbtn = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alertbtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String validatetxt = driver.findElement(By.xpath("//p[@id='result']")).getText();
        System.out.println(validatetxt);

    }
}
