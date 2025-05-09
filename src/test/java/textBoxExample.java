import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class textBoxExample {
    WebDriver driver; //this is declare as a public because this should use in diferet methods.

    @BeforeMethod  //this is the method that execute before the execute test method(linkText)
    public void openLinkPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml"); //if URL is wrong selenium gives the "NO SUCH ELEMENT EXCEPTION" error
    }
    @Test
    public void textBox(){
        //01.type name
        driver.findElement(By.id("j_idt88:name")).sendKeys("Lanka Prasadini");

        //02.append country to city
        /*methanadi me texbox eke already value ekk thiyenwa.api input krna value ek a textbox eke append wenwa withrai.
        a kiynne a thibuna value ek override nowi ekath ekkama api input krna value ek type wenwa.*/

        driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("India");

        //03.verify if text box is disable
        boolean enable = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("text box is disable " + enable);

        //04.clear text
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //05.retreive the typed text
        WebElement retrieveText = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = retrieveText.getAttribute("value");
        System.out.println(value);

        //Type email and Tab. Confirm control moved to next element.
        WebElement nextElement = driver.findElement(By.id("j_idt88:j_idt99"));
        nextElement.sendKeys("lankasilva610@gmail.com" + Keys.TAB + "Confirm control moved to next element");
    }
}
