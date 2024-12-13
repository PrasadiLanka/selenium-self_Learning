import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class googleOpen {

    //using this annotation this code execute as test case without main method.usually we can't run method without main method but because of this annotation we can do that.
    //for best practise when automate the test case it should in the test folder.
    //for use this should add the testNG dependencies.
    @Test
    public void googleTEst(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Colombo" + Keys.ENTER);
    }
}
