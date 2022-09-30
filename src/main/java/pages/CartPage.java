package pages;

import common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractComponent {

    public CartPage(WebDriver driver){ super(driver); }

    @FindBy (css = "button[name='checkout']")
    private WebElement checkout;

    public WebElement setGoToCheckout(WebElement checkout){
        this.checkout=checkout;
        return checkout;
    }

    public void getGoToCheckout(){
        checkout.click();
    }
}
