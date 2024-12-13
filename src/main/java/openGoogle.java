 //import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openGoogle {

    public static void main(String[] args) {
        //open google drive & go to home page
        //one way to implement.bt in this case every time should download chrome driver exe file
        //maven dependency  :- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
        //1st method :- setProperty
        /*
        System.setProperty("webdriver.chrome.diver","/home/lanka/Documents/chromedriver/chromedriver-linux64/chromedriver");
        WebDriver driver = new ChromeDriver();// chrome driver use for open the google
        driver.get("https://www.google.com/"); */

        //2nd method :- webdriver manager
        //in this method web driver manager automatically download the matching chrome driver
        //maven dependency :- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
        //automatically download and save the chrome driver(/home/lanka/.cache/selenium/chromedriver)
        /*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/"); */

        //3rd method :- selenium Manager (this method supports to selenium version 4.diffrence is than previouse method should use version 4 or above in pom.xml file then no need implement setup line)
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.quit();  //close the browser
    }
}
