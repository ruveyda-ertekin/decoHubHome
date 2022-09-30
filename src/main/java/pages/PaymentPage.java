package pages;

import common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends AbstractComponent {

    public PaymentPage(WebDriver driver)  { super(driver); }

    //WebElement cardNumber = driver.findElement(By.xpath("//div[@data-card-fields='number']"));
    @FindBy(xpath = "//div[@data-card-fields='number']")
    private WebElement userCardNumber;

   // WebElement nameonCard = driver.findElement(By.xpath("//div[@data-card-fields='name']"));
    @FindBy(xpath = "//div[@data-card-fields='name']")
    private WebElement userNameOnCard;

    //WebElement expirationDate = driver.findElement(By.xpath("//div[@data-card-fields='expiry']"));
    @FindBy(xpath = "//div[@class='field--half field field--required'][1]")
    private WebElement userExpirationDate;

    //WebElement securityCode = driver.findElement(By.xpath("//div[@data-card-fields='verification_value']"));
    @FindBy(xpath = "//div[@class='field--half field field--required'][2]")
    private WebElement userSecurityCode;

    //WebElement continueButton3 = driver.findElement(By.xpath("//button[@id='continue_button']"));
    @FindBy(xpath = "//button[@id='continue_button']")
    private WebElement payNowButton;

    public void getCreditCartPayment(String cardNumber, String nameOnCard, String expirationDate, String securityCode) {
        userCardNumber.sendKeys(cardNumber);
        userNameOnCard.sendKeys(nameOnCard);
        userExpirationDate.sendKeys(expirationDate);
        userSecurityCode.sendKeys(securityCode);
    }

    public WebElement setPaymentButton(WebElement payNowButton){
        this.payNowButton=payNowButton;
        return payNowButton;
    }

    public void getPayNowClick(){
        payNowButton.click();
    }
}
