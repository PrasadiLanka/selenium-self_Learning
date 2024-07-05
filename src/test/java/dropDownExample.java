import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class dropDownExample {

    WebDriver driver;

    @BeforeMethod
    public void dropdwonPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void leafgroundDropDown() throws InterruptedException {

        //1.1ways of select values in basic dropdown
        /*this is basic dropdwon.thats why this start with select tag.to handle this selenium provides special
		class call "Select". becuase can use methods that include in the Select
		class. 	*/
        driver.get("https://www.leafground.com/select.xhtml");
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        //Thread.sleep(2000);
        //select.deselectByVisibleText("Playwright");

        //1.2 get the number of dropdown option
        //generics
        List<WebElement> dropdownOptions = select.getOptions();
        int size = dropdownOptions.size();
        System.out.println("number of dropdown options = " + size);

        //to print the all options one by one use for each loop
        for(WebElement element:dropdownOptions){
            System.out.println(element.getText());
        }

        //1.3 select the dropdown value using sendkeys
        dropdown.sendKeys("Puppeteer"); // used 1.1 declared dropdown variable

        //1.4 selecting value in boostrap dropdown.boostrap dropdowns not started with select tag
        WebElement dropdown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> dropdown2List = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for(WebElement element : dropdown2List){
            String dropdownValue = element.getText();
            if(dropdownValue.equals("Germany")){
                element.click();
                //break;
            }
        }
    }

    @Test
    //02.google search-pick a value from suggestion
    public void googleSearchDropdown() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("harry potter");
        Thread.sleep(2000);
        List<WebElement> dropdown3List =driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='eIPGRd']"));
        for(WebElement element1 : dropdown3List){
            String dropdownValue = element1.getText();
            if(dropdownValue.equals("Harry Potter and the Philosopher's Stone")){
                element1.click();
                //break;
            }
        }
    }
}

