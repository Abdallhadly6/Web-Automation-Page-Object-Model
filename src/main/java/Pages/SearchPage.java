package Pages;

import Base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

// Define All Elements of LoginPageTest
public class SearchPage extends TestBase {
    JavascriptExecutor js =( (JavascriptExecutor) driver);

    public SearchPage() throws IOException {
        // to define all element in this page
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    WebElement searchInput;

    @FindBy(xpath = "//button[@jsname = 'Tg7LZd']")
    WebElement searchButton;

    @FindBy (xpath = "//span[@aria-current= 'page']")
    WebElement displayIcon;

    // this in search page but i use it to check if i pressed success on photos in home page or not
    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[3]/div[4]/img")
    WebElement displayedPhoto;
    // this like above comment
    public Boolean PhotoDisplay(){
        Boolean isDisplayed = displayedPhoto.isDisplayed();
        js.executeScript("arguments[0].style.border='5px solid red';", displayedPhoto);
        return isDisplayed;
    }

    public void search(String search){
        searchInput.sendKeys(search);
        searchButton.click();
    }

    public Boolean displayedIcon(){
        js.executeScript("arguments[0].style.border='5px solid red';", displayIcon);
        return displayIcon.isDisplayed();
    }





}
