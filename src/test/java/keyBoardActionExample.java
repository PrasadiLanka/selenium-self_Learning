import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class keyBoardActionExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void keyBoardActions1() throws InterruptedException {

        driver.get("https://www.google.com/");
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("Welcome"); // these send keys relevent to webelement class

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform(); // CONTROL+a to selecct all text (Welcome) and release control button

        Thread.sleep(2000);

        actions.keyDown(Keys.SHIFT)
                .sendKeys("capital letters")
                .keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL).perform(); // select the "capital letters" text

                Thread.sleep(2000);

        actions.keyDown(Keys.CONTROL)
                .sendKeys("x") // cut the "capital letters" text
                .build().perform();

    }

    @Test
    public void keyBoardActions2() throws InterruptedException {

        driver.get("https://www.leafground.com/list.xhtml");
        Thread.sleep(4000);

        //to select the many elements like CONTROL+1+2+3+4...
        List<WebElement> selectable = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(selectable.get(0)) /*this is not the web elemnt's click() method.this is in the actions interface.
                                            in this we should say what element going to click.this one says select the first
                                             element, second element... in the ul list */
                .click(selectable.get(1))
                .click(selectable.get(2))
                .keyUp(Keys.CONTROL)
                .perform();
    }
}
