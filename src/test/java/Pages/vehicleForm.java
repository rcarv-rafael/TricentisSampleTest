package Pages;

import com.framework.helper.commonsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class vehicleForm {
    WebDriver driver;
    commonsHelper helper = new commonsHelper();

    public vehicleForm(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id="make")
    public WebElement vehicleMake;

    @FindBy(id="engineperformance")
    public WebElement enginePerformance;

    @FindBy(id="dateofmanufacture")
    public WebElement dateManufacture;

    @FindBy(id="numberofseats")
    public WebElement numberSeats;

    @FindBy(id="fuel")
    public WebElement fuel;

    @FindBy(id="listprice")
    public WebElement listPrice;

    @FindBy(id="licenseplatenumber")
    public WebElement licensePlateNumber;

    @FindBy(id="annualmileage")
    public WebElement annualMileage;

    @FindBy(id="nextenterinsurantdata")
    public WebElement nextButton;

    public void fillOutForm() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(vehicleMake));

        helper.chooseByIndex(vehicleMake, 1);
        enginePerformance.sendKeys("1000");
        dateManufacture.sendKeys("12/31/2000");
        helper.chooseByIndex(numberSeats, 1);
        helper.chooseByIndex(fuel, 1);
        listPrice.sendKeys("50000");
        licensePlateNumber.sendKeys("0123456DEZ");
        annualMileage.sendKeys("50000");
    }

    public void nextStep() {
        nextButton.click();
    }
}