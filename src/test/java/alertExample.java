import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class alertExample {

    WebDriver driver; //this is declare as a public because this should use in diferet methods.

    @BeforeMethod  //this is the method that execute before the execute test method(linkText)
    public void openLinkPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void alert() throws InterruptedException {
        //01.simple alert
        driver.findElement(By.id("j_idt88:j_idt91")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        //02.confirm dialog alert box
        driver.findElement(By.id("j_idt88:j_idt93")).click();
        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(2000);
        alert1.dismiss();

        //03.alert prompt dialog
        driver.findElement(By.id("j_idt88:j_idt104")).click();
        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(2000);
        alert2.sendKeys("My name is Lanka");
        String alertText = alert2.getText();
        System.out.println(alertText);
        alert2.accept();
    }
}
