package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pratice {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
       //WebElement value = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
       //value.sendKeys("selenium");
        ChromeDriver driver1 = new ChromeDriver();
       driver1.navigate().to("https://www.facebook.com/");
       driver1.navigate().to("https://www.google.com/");
       driver1.navigate().refresh();
       driver.close();
       driver1.quit();



    }
}
