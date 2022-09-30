package pages;

import common.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InformationPage extends AbstractComponent {

    WebDriver driver;
    Select stateDropdown;
    Select countryDropdown;
    WebDriverWait wait;

    public InformationPage(WebDriver driver){ super(driver); }

    @FindBy(xpath = "//input[@id='checkout_email']")
    private WebElement userEmail;

    @FindBy(xpath = "//select[@id='checkout_shipping_address_country']")
    private WebElement userDropDownCountry;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_first_name']")
    private WebElement userFirstName ;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_last_name']")
    private WebElement userLastName ;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_company']")
    private WebElement userCompany;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_address1']")
    private WebElement userAddress1;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_address2']")
    private WebElement userAddress2;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_city']")
    private WebElement userCity;

    @FindBy(xpath = "//select[@id='checkout_shipping_address_province']")
    private WebElement userDropDownState;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_zip']")
    private WebElement userZipCode ;

    @FindBy(xpath = "//input[@id='checkout_shipping_address_phone']")
    private WebElement userPhone ;

    @FindBy(xpath = "//button[@id='continue_button']")
    private WebElement continueToShippingButton;

    public WebElement setContinueToShipping(WebElement continueToShippingButton){
        this.continueToShippingButton=continueToShippingButton;
        return continueToShippingButton;
    }

//    public String setLoginApplication(String email, String firstName, String lastName, String company, String address1, String address2, String city, String stateDropdown, String zipCode, String phone) {
//        this.userEmail= email;
//        userFirstName.sendKeys(firstName);
//        userLastName.sendKeys(lastName);
//        userCompany.sendKeys(company);
//        userAddress1.sendKeys(address1);
//        userAddress2.sendKeys(address2);
//        userCity.sendKeys(city);
//
//        //Dropdown element gelecek.dropdownu buraya koymak mantikli mi
//        Select stateDropDown = new Select(userDropDownElement);
//        stateDropDown.selectByVisibleText(stateDropdown);
//
//        userZipCode.sendKeys(zipCode);
//        userPhone.sendKeys(phone);
//    }

    public void getLoginApplication(String email, String countryDropdown, String firstName, String lastName, String company, String address1, String address2, String city, String stateDropdown, String zipCode, String phone) {
        userEmail.sendKeys(email);
        Select countryDropDown = new Select(userDropDownCountry);
        countryDropDown.selectByVisibleText(countryDropdown);
        userFirstName.sendKeys(firstName);
        userLastName.sendKeys(lastName);
        userCompany.sendKeys(company);
        userAddress1.sendKeys(address1);
        userAddress2.sendKeys(address2);
        userCity.sendKeys(city);
        Select stateDropDown = new Select(userDropDownState);
        stateDropDown.selectByVisibleText(stateDropdown);
        userZipCode.sendKeys(zipCode);
        userPhone.sendKeys(phone);
    }

    public void getContinueToShipping(){
        continueToShippingButton.click();
    }

}
