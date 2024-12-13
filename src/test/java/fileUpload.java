import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class fileUpload {

    WebDriver driver;

    @BeforeMethod
    public void fileUpload_Example() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    @Test
    public void herokuappFileUpload(){
        WebElement uploadFile = driver.findElement(By.xpath("(//input[@id='file-upload'])[1]"));
        uploadFile.sendKeys("/home/lanka/Desktop/testing");
        driver.findElement(By.xpath("(//input[@id='file-submit'])[1]")).click();
    }
}
