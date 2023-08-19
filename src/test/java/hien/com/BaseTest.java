package hien.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    @BeforeTest
    public void createBrowser(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");//xử lý cảnh báo (Wamming) Connection reset trong Selenium

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public static void sleep(double seconds){
        try {
            Thread.sleep((long) (1000*seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
