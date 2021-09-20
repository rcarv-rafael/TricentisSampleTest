package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class vehicleForm {
    WebDriver driver;

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

        Select selectObject = new Select(vehicleMake);
        selectObject.selectByIndex(1);

        enginePerformance.sendKeys("1000");
        dateManufacture.sendKeys("12/31/2000");

        Select selectObject1 = new Select(numberSeats);
        selectObject1.selectByIndex(1);

        Select selectObject2 = new Select(fuel);
        selectObject2.selectByIndex(1);

        listPrice.sendKeys("50000");
        licensePlateNumber.sendKeys("0123456DEZ");
        annualMileage.sendKeys("50000");
    }

    public void nextStep() {
        nextButton.click();
    }

}