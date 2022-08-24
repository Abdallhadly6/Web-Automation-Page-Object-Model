package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends TestBase {

    public HomePage() throws IOException {
        // to define all element in this page
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"gb\"]/div/div[1]/div/div[2]/a")
    WebElement PhotosLink;


    public SearchPage pressOnPhotoLink() throws IOException {
        PhotosLink.click();
        return new SearchPage();
    }

}
