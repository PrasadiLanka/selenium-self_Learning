import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Links {
    //Link Text locator - element ientify by link's text
    // Partial Link Text locator - element ientify by only using part of link's text

    WebDriver driver; //this is declare as a public because this should use in diferet methods.

    @BeforeMethod  //this is the method that execute before the execute test method(linkText)
    public void openLinkPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml;jsessionid=node0q0368itnzb3gjhgnugvonowz4193647.node0");
    }
    @Test
    public void linkText() {
        //go to dashboard because of before method
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();  //click the link
        driver.navigate().back(); //back to previouse page

       //broken link checking
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if(title.contains("404")){
            System.out.println("This link is broken");
        }
        else{
            System.out.println("Not broken");
        }
        driver.navigate().back();

        //duplicate link
        //if there are same elements that they are not unique. then selenium takes first element out of all.
        /*homeLinke.click() kiyla use kroth methanadi homeLink kiynne klin use krpu variable ekk.eken wena page ekakata ghin aye
        awith thamai aye me dulicate link ek check krna ekata enne.ethkota methanadi "STALE ELEMENT REFERENCE EXCEPTION" error ek
        enawa.a nisa ehem klin action ekak trigger karanna use krapu variable ekak aye use krnna ba mokda ethkota ake action ek krddi store
         krpu value ek change wela thiyenne aye find elemnt krla thmai aka use krnna pluwan wenne.ehem nthuwa  use krnn pluwan back/foward/refresh me action
         krnne nththn.*/

        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

        //count page links
        //links always start with <a> tag to count links can count the <a> tags in the page
        List<WebElement> totalLinks =  driver.findElements(By.tagName("a")); //many links have with <a>tag.because this should store in the list
        int totalLinksCount = totalLinks.size();
        System.out.println("total links count = " +totalLinksCount);

        //count layout links - only consider about link count of selected layout
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> layoutLinkCount = layoutElement.findElements(By.tagName("a"));
        System.out.println("link count of layout = " +layoutLinkCount.size());

    }
}

