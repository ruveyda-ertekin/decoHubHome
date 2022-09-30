package pages;

import common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends AbstractComponent {

    public ProductsPage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//button[@class='product-form__add-button button button--primary']")
    private WebElement addToCart;
    
    @FindBy(xpath = "//a[normalize-space()='View cart']")
    private WebElement viewCart;

    public WebElement setAddToCart(WebElement addToCart){
        this.addToCart=addToCart;
        return addToCart;
    }

    public WebElement setViewToCart(WebElement viewCart){
        this.viewCart=viewCart;
        return viewCart;
    }

    public void getAddProductToCart() {
        addToCart.click();
    }

    public void getViewProductToCart(){
        viewCart.click();
    }

}
