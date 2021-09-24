package StepDefinitions;

import Pages.insurantForm;
import Pages.priceOptionForm;
import Pages.productForm;
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
    Pages.productForm productForm;
    Pages.priceOptionForm priceOptionForm;

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

    private productForm getproductForm() {
        if (productForm == null) {
            productForm = PageFactory.initElements(driver, productForm.class);
        }

        return productForm;
    }

    private priceOptionForm getpriceOptionForm() {
        if (priceOptionForm == null) {
            priceOptionForm = PageFactory.initElements(driver, priceOptionForm.class);
        }

        return priceOptionForm;
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
    }
    @When("to fill out Product data")
    public void to_fill_out_product_data() {
        getproductForm();
        productForm.fillOutForm();
        productForm.nextStep();
    }

    @When("choose Price option")
    public void choose_price_option() {
        getpriceOptionForm();
        priceOptionForm.fillOutForm();
        priceOptionForm.nextStep();
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
