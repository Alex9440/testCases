package bstu.page2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;

public class Search extends AbstractPage{
    //private final String BASE_URL = "https://Yandex.com/";

    @FindBy(id = "text")
    public WebElement searchQuery;

    @FindBy(className = "input__sample-first-word")
    public WebElement exampleSerch;

    @FindBy(xpath =".//*[text()='Rus']/..")
    public WebElement XPathLangRus;

    @FindBy(xpath =".//*[text()='Bel']/..")
    public WebElement XPathLangBel;

    @FindBy(id ="tabnews_news")
    public WebElement idNews;

    //@FindBy(id ="swiffycontainer")
    //public WebElement adv;

    @FindBy(tagName ="canvas")
    public WebElement adv;

    public Search(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void search(String searchWord)
    {
        searchQuery.clear();
        searchQuery.sendKeys(searchWord);
        searchQuery.submit();

    }

    public boolean isFind(String searchC){
        String[] temp=searchC.split(" ");
        return driver.findElement(By.xpath(".//*[text()='"+temp[0]+"']/..")).isDisplayed();
        //return driver.findElement(By.linkText(temp[0])).isDisplayed();
    }

    public String searchFromExample()
    {
        searchQuery.clear();
        String example=exampleSerch.getText();
        exampleSerch.click();
        return example;
    }

    public void ChangeLang()
    {
        XPathLangRus.click();
        XPathLangBel.click();
    }

    public boolean isLangChange()
    {
        return "Навіны".equals(idNews.getText());
    }

    /*public boolean isAdv()
    {
        (new WebDriverWait(driver, 10, 1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("canvas")));
        return adv.isDisplayed();
    }*/
}