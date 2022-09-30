package pages;

import common.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends AbstractComponent {

    WebDriver driver;
    WebDriverWait wait;

    //encapsulation
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "button[title='Close'][aria-label='Close']")
    private List<WebElement> popUpButton1;

    @FindBy(xpath = "//button[@class='popup-newsletter__close link']")
    private List<WebElement> popUpButton2;

    @FindBy (xpath = "//button[@class='exit-popup__close link']")
    private List<WebElement> popUpButton3;

//    @FindBy (css = ".product-item__title")
//    private List<WebElement> livingRoomSets;
//
    @FindBy (xpath = "//div[@class='product-item product-item--vertical 1/4--lap 1/5--desk 1/6--wide is-selected']")
    private List<WebElement> livingRoomSets;

    private By roomSets = By.cssSelector("//div[@class='product-item product-item--vertical 1/4--lap 1/5--desk 1/6--wide is-selected']");
    private By popUp1 = By.cssSelector("button[title='Close'][aria-label='Close']");
    private By popUp2 = By.xpath("//button[@class='popup-newsletter__close link']");
    private By popUp3 = By.xpath("//button[@class='exit-popup__close link']");

    public void goTo(){
        driver.get("https://decohubhome.com/");
    }

    public By setRoomSets(By roomSets){
        this.roomSets=roomSets;
        return roomSets;
    }

    public By setPopUp1(By popUp1){
        this.popUp1=popUp1;
        return popUp1;
    }

    public By setPopUp2(By popUp2){
        this.popUp2=popUp2;
        return popUp2;
    }

    public By setPopUp3(By popUp3){
        this.popUp3=popUp3;
        return popUp3;
    }

    public List<WebElement> setSelectItem(List<WebElement> livingRoomSets){
        this.livingRoomSets=livingRoomSets;
        return livingRoomSets;
    }

    public List<WebElement> setProductList(){
        waitForElementToAppear(roomSets);
        return livingRoomSets;
    }

    public void getPopUpButtonClose1() {

        waitForElementToAppear(popUp1);
        if(!popUpButton1.isEmpty()){
            popUpButton1.get(0).click();
        }
    }

    public void getPopUpButtonClose2() {

        waitForElementToAppear(popUp2);
        if(!popUpButton2.isEmpty()){
            popUpButton2.get(0).click();
        }
    }

    public void getSelectItem(){
        livingRoomSets.get(7).click();
    }
}
