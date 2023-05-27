package lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Test1 {
    @Test
    public void Testing() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");

        WebElement inputFormSubmit = driver.findElement(By.xpath("//a[contains(text(),'Input Form Submit')]"));
        inputFormSubmit.click();

        WebElement name = driver.findElement(By.cssSelector("#name"));
        name.sendKeys("Liliya");

        WebElement email = driver.findElement(By.cssSelector("#inputEmail4"));
        email.sendKeys("kappanovaliliya98@gmail.com");

        WebElement password= driver.findElement(By.cssSelector("#inputPassword4"));
        password.sendKeys("Chicago12345");

        WebElement company= driver.findElement(By.cssSelector("#company"));
        company.sendKeys("CodeFish");

        WebElement webSite= driver.findElement(By.cssSelector("#websitename"));
        webSite.sendKeys("CodeFish.com");

        WebElement country = driver.findElement(By.xpath("//option[.='United States']"));
        country.click();

        WebElement city= driver.findElement(By.cssSelector("#inputCity"));
        city.sendKeys("Chicago");

        WebElement address1 = driver.findElement(By.cssSelector("#inputAddress1"));
        address1.sendKeys("1423 Port Call");

        WebElement address2 = driver.findElement(By.cssSelector("#inputAddress2"));
        address2.sendKeys("1087 Plum Grove");

        WebElement state = driver.findElement(By.cssSelector("#inputState"));
        state.sendKeys("IL");

        WebElement zipCode = driver.findElement(By.cssSelector("#inputZip"));
        zipCode.sendKeys("76543");

        WebElement submitButton= driver.findElement(By.xpath("//button[.='Submit']"));
        submitButton.click();
        Thread.sleep(2000);

        WebElement message = driver.findElement(By.xpath("//p[@class='success-msg hidden']"));
        String actual = message.getText().trim();
        System.out.println(message.getText());
        String expected = "Thanks for contacting us, we will get back to you shortly.";
        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals(actual,expected);

        System.out.println("this one for github");
    }
}

