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

public class productForm {
    WebDriver driver;
    commonsHelper helper = new commonsHelper();

    public productForm(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id="startdate")
    public WebElement startDate;

    @FindBy(id="insurancesum")
    public WebElement insuranceSum;

    @FindBy(id="meritrating")
    public WebElement meritRating;

    @FindBy(id="damageinsurance")
    public WebElement damageInsurance;

    @FindBy(id="courtesycar")
    public WebElement courtesyCar;

    @FindBy(id="nextselectpriceoption")
    public WebElement nextButton;

    public void fillOutForm() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(startDate));

        startDate.sendKeys("12/31/2021");
        helper.chooseByIndex(insuranceSum, 1);
        helper.chooseByIndex(meritRating, 1);
        helper.chooseByIndex(damageInsurance, 1);
//TODO
//        driver.findElement(By.cssSelector("#EuroProtection")).click();
//        driver.findElement(By.id("LegalDefenseInsurance")).click();
        List<WebElement> lstElements = driver.findElements(By.className("ideal-check"));
        lstElements.get(lstElements.size()-1).click();
//fim todo
        helper.chooseByIndex(courtesyCar, 1);
    }

    public void nextStep() {
        nextButton.click();
    }
}
