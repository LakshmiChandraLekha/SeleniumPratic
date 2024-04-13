package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Assignment {

    WebDriver driver;
    @Test
    public void verifyErrormsg() {

        driver = new ChromeDriver();
        driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement startmyfreetrailbtn = driver.findElement(By.xpath("//button[text()='start my free trial']"));
        startmyfreetrailbtn.click();
        //WebElement firstnameerrormsg = driver.findElement(By.xpath("//input[starts-with(@id,'UserFirstName')]/following-sibling::span"));
        //String Actualerrormsg = firstnameerrormsg.getText();
        //String Expectederrormsg = "Enter your first name";
       // Assert.assertEquals(Actualerrormsg, Expectederrormsg);


        List<String> values = new ArrayList<>();
        values.add("First name");
        values.add("Last name");
        values.add("Email");
        values.add("Job Title");
        values.add("Company");
        values.add("Employees");
        values.add("Phone");

        List<WebElement> actualerrormsgs = driver.findElements(By.xpath("//span[@class='error-msg']/following-sibling::div"));

        List<String> actualerrormsg = new ArrayList<>();

        for(int i=0; i< actualerrormsgs.size() ; i++){
            actualerrormsg.add(geterrorMessage(values.get(i)));
                    }



        List<String>    Expectederrormsgs = new ArrayList<> ();
        Expectederrormsgs.add("Enter your first name");
        Expectederrormsgs.add("Enter your last name");
        Expectederrormsgs.add("Enter a valid email address");
        Expectederrormsgs.add("Select your title");
        Expectederrormsgs.add("Enter your company name");
        Expectederrormsgs.add("Select the number of employees");
        Expectederrormsgs.add("Enter a valid phone number");

        Assert.assertEquals(actualerrormsg, Expectederrormsgs );


    }

        public String geterrorMessage(String inputvalues) {

           String msg =  driver.findElement(By.xpath("//label[normalize-space()='"+inputvalues+"']/following-sibling::span")).getText();
           return msg;
        }














}
