package Pages;

import com.framework.helper.commonsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class insurantForm {
    WebDriver driver;
    commonsHelper helper = new commonsHelper();

    public insurantForm(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id="firstname")
    public WebElement firstName;

    @FindBy(id="lastname")
    public WebElement lastName;

    @FindBy(id="birthdate")
    public WebElement birthDate;

    @FindBy(id="streetaddress")
    public WebElement streetAddress;

    @FindBy(id="country")
    public WebElement country;

    @FindBy(id="zipcode")
    public WebElement zipCode;

    @FindBy(id="city")
    public WebElement city;

    @FindBy(id="occupation")
    public WebElement occupation;

    @FindBy(id="website")
    public WebElement website;

    @FindBy(id="nextenterproductdata")
    public WebElement nextButton;

    public void fillOutForm() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(firstName));

        firstName.sendKeys("Primeiro");
        lastName.sendKeys("Ultimo");
        birthDate.sendKeys("12/31/1980");
//TODO
//            driver.findElements(By.name("Gender");
//            driver.findElement(By.cssSelector("#gendermale")).click();
        List<WebElement> lstGender = driver.findElements(By.className("ideal-radiocheck-label"));
        lstGender.get(1).click();
//FIM TODO
        streetAddress.sendKeys("Av. Last Avenue");
        helper.chooseByIndex(country, 1);
        zipCode.sendKeys("12345678");
        city.sendKeys("Cidade QA");
        helper.chooseByIndex(occupation, 1);

        List<WebElement> lstElements = driver.findElements(By.className("ideal-radiocheck-label"));
        lstElements.get(5).click();

        website.sendKeys("www.teste.com");
//TODO   tem q ser com autoit         driver.findElement(By.id("open")).click();
//        File file = new File("resources/img/Identity_Card.png");
//        String absolutePath = file.getAbsolutePath();
    }

    public void nextStep() {
        nextButton.click();
    }
}
