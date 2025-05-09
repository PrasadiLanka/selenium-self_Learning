import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class mouseActionsExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void mouseOperationsTest1() throws InterruptedException {

        driver.get("https://www.leafground.com/drag.xhtml");

        //1.move to element - cursor move to these elements without click.like hover
        Actions actions = new Actions(driver); // Actions class include in the selenium interaction package
        actions.moveToElement(driver.findElement(By.xpath("//i[@class='pi pi-globe layout-menuitem-icon']"))).perform();
        //find the element that want to reach.
        //not enough the find element also should call the perform method.can write this way build().perform(); also
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.xpath("//i[@class='pi pi-server layout-menuitem-icon']"))).perform();
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.xpath("//i[@class='pi pi-table layout-menuitem-icon']"))).perform();

        //2.drag & drop operation
        WebElement from = driver.findElement(By.xpath("//div[@id='form:drag_content']"));
        WebElement to = driver.findElement(By.xpath("//div[@id='form:drop_content']"));

        //1st way - actions.clickAndHold(from).moveToElement(to).release(to).perform();
        actions.dragAndDrop(from,to).perform();  //2nd way

        //3.slider operations
        WebElement sliderPoint = driver.findElement(By.xpath("(//div[@id='form:j_idt125'])[1]"));
        System.out.println("slider point location before moving : " + sliderPoint.getLocation()); //slider point loaction before move
        actions.dragAndDropBy(sliderPoint, 50,0).perform();
        System.out.println("slider point location after moving : " + sliderPoint.getLocation());

    }

    @Test
    public void mouseOperationsTest2(){

        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        WebElement rightClickBtn = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions actions1 = new Actions (driver);
        actions1.contextClick(rightClickBtn).perform(); // for the right click, Actions class supply this contexClick() method
        driver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();
        Alert alertPop = driver.switchTo().alert();
        System.out.println("Alert shows the text as " +alertPop.getText());
        alertPop.accept();


    }
}
