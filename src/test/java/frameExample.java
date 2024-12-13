import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class frameExample {
    WebDriver driver;

    @BeforeMethod
    public void openLinkPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
    }

    @Test
    public void frameTests(){

        //1. click me (inside frame)
        driver.switchTo().frame(0); //web driver focus only relevant html page.to get the focus for iframe should switch to it.

        WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();

        String afterClickButtonText = button1.getText();
        System.out.println("button click after text is " +afterClickButtonText);

        //2. click me (inside nested frame)
        driver.switchTo().defaultContent(); // at this time driver focus to previously focused iframe. now going to focus another iframe.to do that should focus to default html page then can switch to relevant iframe.

        driver.switchTo().frame(2); // inside in to 3rd frame
        driver.switchTo().frame("frame2"); // inside into third frame > child frame

        WebElement button3 = driver.findElement(By.xpath("//button[@id='Click']"));
        button3.click();

        String afterClickNestedButtonText = button3.getText();
        System.out.println("Nested button click after text is " +afterClickNestedButtonText);

        driver.switchTo().defaultContent();

        List<WebElement> iframeCount = driver.findElements(By.tagName("iframe"));
        int size = iframeCount.size();
        System.out.println("Iframe count is " +size); //answer is 3.that's why now in the default/main html page.actually there 4 iframe.but nested iframes not focus to main page.
    }
}

