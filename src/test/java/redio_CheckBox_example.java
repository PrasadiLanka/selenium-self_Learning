import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class redio_CheckBox_example {

    WebDriver driver;

    @BeforeMethod
    public void radio_checkbox_Example() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/radio.xhtml");
    }

    @Test
    public void radioButton() {

        //01.Find the default select radio button
        //isSelect() method only support for started with <input> tags.bcz of that in this case should use <input id>
        boolean chromeOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (chromeOption) {
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("default select radio button is " + chromeText);
        } else if (firefoxOption) {
            String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("default select radio button is " + firefoxText);
        } else if (safariOption) {
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("default select radio button is " + safariText);
        } else if (edgeOption) {
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("default select radio button is " + edgeText);
        }

        //02. select the age group only if not selected
        WebElement myAge = driver.findElement(By.id("j_idt87:age:0"));
        boolean isCheck = myAge.isSelected();
        if(!isCheck){
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }
    }

    @Test
    public void checkBox(){
        //1.select wanted checkbox and verifying those checkboxes selected status
        driver.get("https://www.leafground.com/checkbox.xhtml");

        List<WebElement> checkBoxList =  driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for(WebElement element:checkBoxList){
            if(!(element.getText().equals("Others"))){
                element.click();
            }
        }
        for(int i=1 ; i<=checkBoxList.size();i ++){
           boolean checkBoxStatus =  driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" + i+ "]")).isSelected();
            System.out.println("CheckBox" + i + "selected status is : " + checkBoxStatus);
        }
    }
}
