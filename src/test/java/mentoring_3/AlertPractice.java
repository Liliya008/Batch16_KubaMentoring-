package mentoring_3;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class AlertPractice {
    @Test
    public void practice1() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");

        WebElement JsAlert = driver.findElement(By.linkText("Javascript Alerts"));
        JsAlert.click();
        WebElement jsAlertClickMe = driver.findElement(By.xpath("//p[contains(text(),'JS Alert')]//button"));
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement confirmBox = driver.findElement(By.xpath("//p[contains(text(),'Confirm box:')]//button"));
        alert.dismiss();
        WebElement message = driver.findElement(By.cssSelector("#confirm-demo"));
        Assert.assertEquals(BrowserUtils.getText(message),"You pressed Cancel!");
        WebElement promptBox = driver.findElement(By.xpath("//p[contains(text(),'Prompt box:')]//button"));
        alert.sendKeys("Liliya");
        alert.accept();
        WebElement message2 = driver.findElement(By.cssSelector("#prompt-demo"));
        Assert.assertEquals(BrowserUtils.getText(message2),"You have entered 'Liliya' !");
    }
}