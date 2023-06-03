package mentoring_3;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TumblrTask {
    @Test
    public void task() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.tumblr.com/");
        /*
        Navigate to webapp
click login button
click continue with email button
provide email, and password (wrong credentials)
and validate the error message
driver quit
         */
        WebElement logInButton=driver.findElement(By.linkText("Log in"));
        logInButton.click();
        WebElement continueWithEmail = driver.findElement(By.xpath("//button[@aria-label='Continue with email']"));
        continueWithEmail.click();
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("liliya@gmail.com");
        WebElement nextButton1 = driver.findElement(By.xpath("//form/div[1]/div[1]/button/span"));
        nextButton1.click();
        WebElement password= driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("123");
        WebElement nextButton2 = driver.findElement(By.xpath("//span[.='Log in']"));
        nextButton2.click();
        WebElement message = driver.findElement(By.xpath("//div[@class='a0A37 hAkP2']"));
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(message),"Your email or password were incorrect.");




    }
}
