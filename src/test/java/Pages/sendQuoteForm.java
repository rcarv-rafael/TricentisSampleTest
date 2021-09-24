package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class sendQuoteForm {
    WebDriver driver;

    public sendQuoteForm(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="phone")
    public WebElement phone;

    @FindBy(id="username")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="confirmpassword")
    public WebElement confirmPassword;

    @FindBy(id="Comments")
    public WebElement comments;

    @FindBy(id="sendemail")
    public WebElement sendButton;

    public void fillOutForm() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(email));

        email.sendKeys("novo@teste.com");
        phone.sendKeys("12345678");
        userName.sendKeys("test1");
        password.sendKeys("123Teste");
        confirmPassword.sendKeys("123Teste");
        comments.sendKeys("Comentario");
    }

    public void sendEmail() {
        sendButton.click();
    }
}
