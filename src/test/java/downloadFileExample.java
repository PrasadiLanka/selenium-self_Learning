import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class downloadFileExample {
    WebDriver driver;

    @BeforeMethod
    public void openLinkPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void fileDownloadTest() throws InterruptedException {

        //download the file
        driver.get("https://www.leafground.com/file.xhtml");
        WebElement downloadBtn = driver.findElement(By.xpath("//span[normalize-space()='Download']"));
        downloadBtn.click();
        Thread.sleep(2000);

        //check the download is success
        File file = new File("/home/lanka/Downloads");   //file downloaded path
        File[] totalFiles = file.listFiles();

        for(File findFile:totalFiles){
            if (findFile.getName().equals("TestLeaf Logo.png")){
                System.out.println("Download Succesfull");
                break;
            }

        }
    }

    @Test
    public void fileUpload() throws AWTException, InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");


//        //1st way - using robot class (issue with linux OS)
//        WebElement uploadBTn = driver.findElement(By.id("j_idt88:j_idt89"));
//        uploadBTn.click();
//
//        /*after this part open the laptop's window(linux)then that is can not handle by the
//        selenium.to handle that part should use the java.*/
//
//        StringSelection selection = new StringSelection("/home/lanka/Downloads/pp_princess_snowwhite_static_mobile_20694_65502630.jpeg");
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);    /*before upload the file should copy the path that going to upload.that path should copied
//                                                                                                  to clipboard.this line for that.this setContents only accept transferablecontents.because we can't send
//                                                                                                   string values directly.*/
//
//        Robot robot = new Robot();  /* should declare this robot class to work with keyboard actions(paste that copied path). we can't use Actions class for this.
//                                    Actions class methods only can use for web driver or selenium things. now this is not connect with selenium until this works as OS
//                                    application.using this class can perform keyboard actions*/
//        Thread.sleep(3000);
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//
//        Thread.sleep(3000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);



        //2nd way - using send keys (Applicable only element type is file.that means the locator of upload button, html element input type = "file" )
        String data = "/home/lanka/Downloads/pp_princess_snowwhite_static_mobile_20694_65502630.jpeg";
        WebElement uploadUsingSendKeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadUsingSendKeys.sendKeys(data);
    }
}
