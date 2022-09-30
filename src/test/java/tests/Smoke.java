package tests;

import java.util.concurrent.TimeUnit;
import common.AbstractComponent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Smoke {

    WebDriver driver;
    WebDriverWait wait;
    /**
     * Constructor
     */

    /**
     * Set up browser settings and open the Web Page
     */
    @BeforeMethod
    public void setUp() throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown()  {
        driver.quit();
    }

    @Test
    public void shouldSuccessfullyPurchaseTheItem() throws InterruptedException{

        AbstractComponent abstractComponent = new AbstractComponent(driver);
        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        InformationPage informationPage = new InformationPage(driver);
        ShippingPage shippingPage = new ShippingPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);

        homePage.goTo();

        homePage.getPopUpButtonClose1();
        homePage.getPopUpButtonClose2();

        abstractComponent.implicitlyWait();
        abstractComponent.scrollDownPage();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getSelectItem));

        homePage.getSelectItem();
        productsPage.getAddProductToCart();
        productsPage.getViewProductToCart();
        cartPage.getGoToCheckout();

        abstractComponent.implicitlyWait();
        //abstractComponent.waitForElementToAppear(informationPage.email);
        informationPage.getLoginApplication("rachelallison578@gmail.com", "United States", "Harry", "Potter", "Amazon", "Test Street 12345", "East", "Atlanta",
                "Georgia", "30318","123456789");

        abstractComponent.scrollDownPage();
        abstractComponent.implicitlyWait();
        informationPage.getContinueToShipping();
        abstractComponent.implicitlyWait();
        shippingPage.getContinueToPayment();

//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-card-fields='number']")));
//
//        paymentPage.getCreditCartPayment("30318789456123", "Harry Potter", "0127", "123");
//
//        abstractComponent.scrollDownPage();
       // paymentPage.getPayNowClick;
//hello23
    }
}
