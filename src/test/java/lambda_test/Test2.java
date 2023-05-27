package lambda_test;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.TreeMap;

public class Test2 {
    @Test
    public void test2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");

        driver.findElement(By.xpath("//a[contains(.,'Table Pagination')]")).click();

        WebElement selectBox = driver.findElement(By.cssSelector("#maxRows"));
        BrowserUtils.selectBy(selectBox,"0","index");

        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmail = driver.findElements(By.xpath("//tr//td[3]"));

        TreeMap<String, String> map = new TreeMap<>();
        for (int i = 0; i < allNames.size(); i++) {

            map.put(BrowserUtils.getText(allNames.get(i)), BrowserUtils.getText(allEmail.get(i)));

        }
        System.out.println("map = " + map);
        }
        @Test
    public void fullNameNumber() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("https://www.lambdatest.com/selenium-playground");

            driver.findElement(By.xpath("//a[contains(.,'Table Pagination')]")).click();

            WebElement selectBox = driver.findElement(By.cssSelector("#maxRows"));
            BrowserUtils.selectBy(selectBox,"5000","value");

            List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
            List<WebElement> allNumbers = driver.findElements(By.xpath("//tr//td[4]"));

            TreeMap<String, Long> map = new TreeMap<>();
            for (int i = 0; i < allNames.size(); i++) {


                map.put(BrowserUtils.getText(allNames.get(i)), Long.parseLong(BrowserUtils.getText(allNumbers.get(i)).replace("-","")));

            }
            System.out.println("map = " + map);
        }
        }


