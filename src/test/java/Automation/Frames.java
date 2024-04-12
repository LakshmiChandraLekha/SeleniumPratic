package Automation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Frames {
    WebDriver driver;
    @Test
    public void switchToframes(){

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement lefttext = driver.findElement(By.xpath("//body[normalize-space()='LEFT']"));
        System.out.println(lefttext.isDisplayed());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement righttext = driver.findElement(By.xpath("//body[normalize-space()='RIGHT']"));
        System.out.println(righttext.isDisplayed());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottomtext = driver.findElement(By.xpath("//body[normalize-space()='BOTTOM']"));
        System.out.println(bottomtext.isDisplayed());




    }


}
