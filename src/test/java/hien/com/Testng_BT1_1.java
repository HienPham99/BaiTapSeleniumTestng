package hien.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testng_BT1_1 extends BaseTest {

    @Test(priority = 1)
    public void testLoginRise() {

        driver.get("https://rise.fairsketch.com/signin");

        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).clear();

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@demo.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("riseDemo");
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        String headerDashboard = driver.findElement(By.xpath("//h4[normalize-space()='Tasks']")).getText();
        softAssert.assertEquals(headerDashboard, "Tasks", "Header Dashboard chưa đúng page");
        System.out.println("TCs 1: Login successfully. Hiển thị title của dashboard là: " + headerDashboard);

        softAssert.assertAll();
        sleep(1);

    }

    @Test(priority = 2)
    public void addClients() {

        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        String headerClientsPage = driver.findElement(By.xpath("//ul[@id='client-tabs']")).getText();
        softAssert.assertTrue(headerClientsPage.contains("Clients"));
        System.out.print("TCs 2: Header Clients page gồm: " + headerClientsPage);

        //Click btn Add client
        driver.findElement(By.xpath("//ul[@id='client-tabs']/div/div/a[3]")).click();
        //Kiểm tra title của form Add new client
//        String titleAddNewClient = driver.findElement(By.xpath("//h4[@id='ajaxModalTitle']")).getText();
//        softAssert.assertEquals(titleAddNewClient, "Add client", "không pải page add new client");

        driver.findElement(By.xpath("//label[@for='company_name']/following-sibling::div/input")).sendKeys("qc");
        driver.findElement(By.xpath("//label[@for='created_by']/following-sibling::div/div")).click();
        driver.findElement(By.xpath("//input[@id='s2id_autogen3_search']")).sendKeys("J", Keys.ENTER);
        driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("Đông anh, Hà Nội");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Hà Nội");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("12345A");
        driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("12ABC");
        driver.findElement(By.xpath("//input[@id='country']")).sendKeys("VietNam");
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("0987655432");
        driver.findElement(By.xpath("//input[@id='website']")).sendKeys("HienQC@.com");
        driver.findElement(By.xpath("//input[@id='vat_number']")).sendKeys("10");
        driver.findElement(By.xpath("//input[@id='s2id_autogen2']")).sendKeys("v", Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='s2id_autogen2']")).sendKeys("g", Keys.ENTER);
       // driver.findElement(By.xpath("//div[@id='select2-drop-mask']")).click();

        //bắt 1 element bị khuất ở màn hình
//        WebElement element1 = driver.findElement(By.xpath("//input[@id='s2id_autogen1_search']"));
//        Actions action = new Actions(driver);
//
//        //Di chuyển con trỏ tới element
//        action.moveToElement(element1).build().perform();
//
//        driver.findElement(By.xpath("//input[@id='s2id_autogen1_search']")).sendKeys("EUR", Keys.ENTER);
//        driver.findElement(By.xpath("//input[@id='currency_symbol']")).sendKeys("fffff");
//
//        driver.findElement(By.xpath("//label[normalize-space()='Labels']/following-sibling::div/input[@type='text']")).sendKeys("in", Keys.ENTER);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleep(2);
        driver.findElement(By.xpath("//a[@role='presentation'][normalize-space()='Clients']")).click();

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("qc",Keys.ENTER);
        WebElement name = driver.findElement(By.xpath("//tbody/tr/td[2]"));
        System.out.println(name.getText().length());

        softAssert.assertAll();

    }


}
