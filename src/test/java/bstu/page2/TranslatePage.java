package bstu.page2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TranslatePage extends AbstractPage{
    //private final String BASE_URL = "https://translate.yandex.by/";

    @FindBy(id = "textarea")//
    public WebElement textBoxEng;

    @FindBy(id = "dictionaryContent")//"translation")//"translationLayer")//"textbox2")//
    public WebElement textBoxRus;

    @FindBy(className = "button button_swap")//"translation")//"translationLayer")//"textbox2")//
    public WebElement button;

    public TranslatePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }


    public boolean isTranslated(String textRus){
        (new WebDriverWait(driver, 10, 1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='сыр']/..")));
        return driver.findElement(By.xpath(".//*[text()='сыр']/..")).isDisplayed();
    }

    public void translate(String textEng){
        textBoxEng.sendKeys(textEng);
    }
}