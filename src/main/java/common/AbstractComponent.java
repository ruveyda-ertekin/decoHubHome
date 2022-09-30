package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AbstractComponent {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor jse;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        this.jse= (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElementToAppear(By findBy){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForElementToAppear(WebElement element){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
    }

    public void waitForElementToDisappear(WebElement element) throws InterruptedException{
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void implicitlyWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
    }

    public void scrollDownPage(){
        for (int i = 0; i < 10; i++) {
            jse.executeScript("window.scrollBy(0,230)");
        }
    }
}
