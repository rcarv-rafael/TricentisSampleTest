package StepDefinitions;

import Pages.insurantForm;
import Pages.vehicleForm;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class insuranceFormSteps {
    WebDriver driver = null;
    WebDriverWait wait = null;

    Pages.vehicleForm vehicleForm;
    Pages.insurantForm insurantForm;

    private vehicleForm getVehicleForm() {
        if (vehicleForm == null) {
            vehicleForm = PageFactory.initElements(driver, vehicleForm.class);
        }

        return vehicleForm;
    }

    private insurantForm getinsurantForm() {
        if (insurantForm == null) {
            insurantForm = PageFactory.initElements(driver, insurantForm.class);
        }

        return insurantForm;
    }

    @Before
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Given("user is on main Request Insurance form page")
    public void user_is_on_main_request_insurance_form_page() {
        driver.get("http://sampleapp.tricentis.com/101/app.php");
        wait.until(presenceOfElementLocated(By.id("make")));
        driver.findElement(By.id("nav_automobile")).click();
        WebElement firstResult = wait.until(presenceOfElementLocated(By.id("make")));
    }

    @When("to fill out Vehicle data")
    public void to_fill_out_vehicle_data() {
        getVehicleForm();
        vehicleForm.fillOutForm();
        vehicleForm.nextStep();
    }

    @When("to fill out Insurant data")
    public void to_fill_out_insurant_data() {
        getinsurantForm();
        insurantForm.fillOutForm();
        insurantForm.nextStep();

//        wait.until(presenceOfElementLocated(By.id("firstname")));
//        driver.findElement(By.id("firstname")).sendKeys("Primeiro");
//        driver.findElement(By.id("lastname")).sendKeys("Ultimo");
//        driver.findElement(By.id("birthdate")).sendKeys("12/31/1980");
////TODO
////            driver.findElements(By.name("Gender");
////            driver.findElement(By.cssSelector("#gendermale")).click();
//        List<WebElement> lstGender = driver.findElements(By.className("ideal-radiocheck-label"));
//        lstGender.get(1).click();
////FIM TODO
//
//        driver.findElement(By.id("streetaddress")).sendKeys("Av. Last Avenue");
//
//        WebElement countryElement = driver.findElement(By.id("country"));
//        Select countryObject = new Select(countryElement);
//        countryObject.selectByIndex(1);
//
//        driver.findElement(By.id("zipcode")).sendKeys("12345678");
//        driver.findElement(By.id("city")).sendKeys("Cidade QA");
//
//        WebElement occupationElement = driver.findElement(By.id("occupation"));
//        Select occupationObject = new Select(occupationElement);
//        occupationObject.selectByIndex(1);
//
//        List<WebElement> lstElements = driver.findElements(By.className("ideal-radiocheck-label"));
//        lstElements.get(5).click();
//
//        driver.findElement(By.id("website")).sendKeys("www.teste.com");
//
//        //   tem q ser com autoit         driver.findElement(By.id("open")).click();
//        File file = new File("resources/img/Identity_Card.png");
//        String absolutePath = file.getAbsolutePath();
//
//        driver.findElement(By.id("nextenterproductdata")).click();
    }
    @When("to fill out Product data")
    public void to_fill_out_product_data() {
        wait.until(presenceOfElementLocated(By.id("startdate")));
        driver.findElement(By.id("startdate")).sendKeys("12/31/2021");

        WebElement insurancesumElement = driver.findElement(By.id("insurancesum"));
        Select insurancesumObject = new Select(insurancesumElement);
        insurancesumObject.selectByIndex(1);

        WebElement meritratingElement = driver.findElement(By.id("meritrating"));
        Select meritratingObject = new Select(meritratingElement);
        meritratingObject.selectByIndex(1);

        WebElement damageinsuranceElement = driver.findElement(By.id("damageinsurance"));
        Select damageinsuranceObject = new Select(damageinsuranceElement);
        damageinsuranceObject.selectByIndex(1);
//TODO
//        driver.findElement(By.cssSelector("#EuroProtection")).click();
//        driver.findElement(By.id("LegalDefenseInsurance")).click();
        List<WebElement> lstElements = driver.findElements(By.className("ideal-check"));
        lstElements.get(lstElements.size()-1).click();
//fim todo
        WebElement courtesycarElement = driver.findElement(By.id("courtesycar"));
        Select courtesycarObject = new Select(courtesycarElement);
        courtesycarObject.selectByIndex(1);

        driver.findElement(By.id("nextselectpriceoption")).click();
    }

    @When("choose Price option")
    public void choose_price_option() {
        wait.until(presenceOfElementLocated(By.id("nextsendquote")));
        List<WebElement> lstElements = driver.findElements(By.className("ideal-radio"));
        lstElements.get(lstElements.size()-1).click();
        wait.until(presenceOfElementLocated(By.id("downloadquote")));
        wait.until(elementToBeClickable(By.id("nextsendquote")));

        driver.findElement(By.id("nextsendquote")).click();
    }

    @When("send Quote")
    public void send_quote() {
        driver.findElement(By.id("email")).sendKeys("novo@teste.com");
        driver.findElement(By.id("phone")).sendKeys("12345678");
        driver.findElement(By.id("username")).sendKeys("test1");
        driver.findElement(By.id("password")).sendKeys("123Teste");
        driver.findElement(By.id("confirmpassword")).sendKeys("123Teste");
        driver.findElement(By.id("Comments")).sendKeys("Comentario");

        driver.findElement(By.id("sendemail")).click();
    }
    @Then("see success message.")
    public void see_success_message() {
        wait.until(presenceOfElementLocated(By.className("sweet-alert")));
        assertEquals("Sending e-mail success!", driver.findElement(By.cssSelector(".sweet-alert h2")).getText());
        driver.findElement(By.className("confirm")).click();
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
