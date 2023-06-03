package mentoring_3;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;

import java.time.Duration;

public class Sliders {
    @Test
    public void sliderPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");

        WebElement dragAndDrop = driver.findElement(By.linkText("Drag & Drop Sliders"));
        dragAndDrop.click();
        List<WebElement>  allInputs=driver.findElements(By.xpath("//input[@type='range']"));
        List<WebElement> allOutput = driver.findElements(By.cssSelector("output"));

        for (int i = 0; i < allInputs.size(); i++) {
            while (!allOutput.get(i).getText().equals("50")){
                if(allOutput.get(i).getText().equals("50")){
                    break;
                }else{
                    allInputs.get(i).sendKeys(Keys.ARROW_RIGHT);
                }

            }

        }

    }
}
