import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
}
