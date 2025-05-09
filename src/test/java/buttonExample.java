import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class buttonExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkPage(){
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800,600);
        driver.manage().window().setSize(newSize);
        driver.get("https://www.leafground.com/button.xhtml");
    }
    @Test
    public void buttonTest(){
        //01.click and confirm title

        driver.findElement(By.xpath("//span[normalize-space()='Click']")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) { //this also can write as actualTitle.equals(expexctedTitle)
            System.out.println("Actual title same as expected");
        }
        else{
                System.out.println("Actual title not same as expected");
            }

            //02.find the position of the submit button
            driver.navigate().back();
            WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
            Point xyPoint = getPosition.getLocation();
            int x = xyPoint.getX();
            int y = xyPoint.getY();
            System.out.println("X position is " + x + " Y position is " + y);

            //03.find the save button color
            WebElement buttoncolor = driver.findElement(By.id("j_idt88:j_idt96"));
            String color = buttoncolor.getCssValue("background-color");
            System.out.println("Button color is " + color);

            //04.Find the height and width of button
            WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
            /*me wge ek method ekkin thawa method ekak call krna awasthawe wenne getSize() kiyna method ekta adalawa
            thiyena pre define methods apita pluwan dot ek use krla access krna.akata kiynne method chaining kiyla.
            ehem wenne getSize() ek return krnne dimension value.a dimension class ek atule thiyena anith
            methods dot ek thiyla (method chaining nisa) access krnna pluwan wena nisa
             */
            int height = size.getSize().getHeight();
            int width = size.getSize().getWidth();
            System.out.println("Height is " + height + " Width is " + width);
        }
    }

