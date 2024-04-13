package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Windows {

    WebDriver driver;
@Test
    public void handleWindows() {

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement btn = driver.findElement(By.xpath("//a[text()='Click Here']"));
        btn.click();
        String parent = driver.getWindowHandle();
        System.out.println(parent);
        Set<String> windowsids = driver.getWindowHandles();

        for(String windows: windowsids) {
            String title = driver.switchTo().window(windows).getTitle();
            System.out.println(title);
            if (title.equals("New Window")) {
                String txt = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
                System.out.println(txt);
            }
            driver.switchTo().window(parent);
            Assert.assertTrue(btn.isDisplayed());
        }

        //driver.switchTo().newWindow(WindowType.WINDOW);
        driver.switchTo().newWindow(WindowType.TAB);
        //driver.quit();
    driver.close();




    }
}
