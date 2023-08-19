package hien.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_BT1 extends BaseTest {

    @Test(priority = 1)
    public void loginCMS() {
        System.out.println("Login");
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

    }

    @Test(priority = 2)
    public void addCategory() {
        System.out.println("Add Category");

        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        String titleCategory = driver.findElement(By.xpath("//h1[normalize-space()='All Categories']")).getText();
        softAssert.assertEquals(titleCategory, "All Categories", "Title category chưa đúng yêu cầu");
        sleep(2);

        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();
        String titleAddNewCategory = driver.findElement(By.xpath("//h5[normalize-space()='Category Information']")).getText();
        System.out.println(titleAddNewCategory);
        softAssert.assertEquals(titleAddNewCategory, "Category Information", "Chưa đúng title của Add new category page");

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Category12");
        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Computer", Keys.ENTER);
        sleep(1);
        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("123456",Keys.ENTER);
       //driver.findElement(By.xpath("//label[normalize-space()='Banner (200x200)']/following-sibling::div/div/div[normalize-space()='Browse']]")).click();
        sleep(1);
        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("Category12",Keys.ENTER);
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("Description...");
        driver.findElement(By.xpath("//div[contains(text(),'Nothing selected')]")).click();
        sleep(1);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Size",Keys.ENTER);
        sleep(2);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        sleep(2);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Category123",Keys.ENTER);
        sleep(2);
       String categoryItem = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
        System.out.println("Get category item: " + categoryItem);
       Assert.assertEquals(categoryItem, "Category12", "không đúng item đã added");
       sleep(2);

        softAssert.assertAll();

    }

}
