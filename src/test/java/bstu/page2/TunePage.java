package bstu.page2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TunePage extends AbstractPage{

    @FindBy(xpath =".//*[text()='Ru']/..")
    public WebElement XPathLangRus;

    @FindBy(xpath =".//*[text()='En']/..")
    public WebElement XPathLangBel;

    @FindBy(className ="b-head-line__path")
    public WebElement Settings;

    @FindBy(className="b-form-input__input")
    public WebElement regionText;

    @FindBy(xpath = ".//*[text()='Настройка']/..")
    public WebElement SettingsMain;

    @FindBy(xpath = ".//*[text()='Изменить город']/..")
    public WebElement SettingsRegion;


    public TunePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }


    public void ChangeLang()
    {
        XPathLangRus.click();
        XPathLangBel.click();
    }

    public boolean isLangChange()
    {
        return "settings".equals(Settings.getText());
    }

    public void ChangeRegion()
    {
        SettingsMain.click();
        SettingsRegion.click();
        driver.findElement(By.id("auto")).click();
        (new WebDriverWait(driver, 10, 1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("b-form-input__input")));

        regionText.sendKeys("Москва");
        driver.findElement(By.name("no_location")).click();
        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[3]/form/span[2]/input")).click();
    }

    public boolean isRegionChanged()
    {
        return driver.findElement(By.xpath(".//*[text()='в Москве']/..")).isDisplayed();
    }
}