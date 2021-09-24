package Pages;

import com.framework.helper.commonsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class priceOptionForm {
    WebDriver driver;

    public priceOptionForm(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id="priceTable")
    public WebElement priceTable;

    @FindBy(className="ideal-radio")
    public List<WebElement> radioPrice;

    @FindBy(id="downloadquote")
    public WebElement downloadQuote;

    @FindBy(id="nextsendquote")
    public WebElement nextButton;

    public void fillOutForm() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(priceTable));

        radioPrice.get(radioPrice.size()-1).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(downloadQuote));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(nextButton));
    }

    public void nextStep() {
        nextButton.click();
    }
}
