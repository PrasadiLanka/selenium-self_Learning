import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class windowsExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
    }

    @Test
    public void windowTests() throws InterruptedException {

        //1.click & confirm new window opens

        String oldWindow =driver.getWindowHandle(); //this method use for identify the parent window
        System.out.println("Parent Window : " +oldWindow);

        WebElement openButton =  driver.findElement(By.xpath("//span[normalize-space()='Open']"));
        openButton.click();
        Thread.sleep(2000);

        Set<String> handles = driver.getWindowHandles(); //after click the openButton another tab is open.this method can use to calculate the no of windows.
        System.out.println("Handles size is " + handles.size());

        //1st method - using foreach loop

        for (String newWindow : handles){
            System.out.println(newWindow);
            driver.switchTo().window(newWindow);
            System.out.println("Page title is : " + driver.getTitle()); // 1st iteration switch to window (parent) page. 2nd iteration switch to dashboard (child) page.
        }

        Thread.sleep(2000);
        driver.close(); // child window close.only closing this window doesn't focus to child window.

        driver.switchTo().window(oldWindow); // driver focus to parent window.

        //check this element available in the page to test now in the correct page
        WebElement openButton1 = driver.findElement(By.xpath("//span[normalize-space()='Open']"));
        boolean openButton1Visibility = openButton1.isDisplayed();
        System.out.println(openButton1Visibility);

        //2.find the no of opened tabs
        WebElement multiWindowButton = driver.findElement(By.xpath("//span[normalize-space()='Open Multiple']"));
        multiWindowButton.click();
        Thread.sleep(3000);

        Set<String> multiWindows = driver.getWindowHandles();
        int numOfWindows = multiWindows.size();
        System.out.println("No of opened windows : " +numOfWindows);

        //3. Close all windows except primary
        WebElement dontCloseButton = driver.findElement(By.xpath("//span[normalize-space()='Close Windows']"));
        dontCloseButton.click();
        Thread.sleep(3000);

        Set<String> newWindowHandles  = driver.getWindowHandles(); // at this time 6 windows opened with previously opened ones.
        for(String allWindows:newWindowHandles) {
            if (!allWindows.equals(oldWindow)){ // old window eke neweida kiyla check krnwa.if not close that windows.
                driver.switchTo().window(allWindows);
                driver.close();

                // driver.close() - close the driver focus browse window.
                // driver.quit() - close all browser windows.
            }
        }
            driver.quit(); // to close the parent window
    }
}