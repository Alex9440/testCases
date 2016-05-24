package bstu.page2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage extends AbstractPage{
    //private final String BASE_URL = "https://mail.yandex.by/";

    @FindBy(name = "login")//
    public WebElement signInEmail;

    @FindBy(name = "passwd")//
    public WebElement signInPassword;

    @FindBy(xpath = "//button[@type='submit']")//
    public WebElement signInLogin;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void logIn(String email, String password)
    {
        signInEmail.clear();
        signInEmail.sendKeys(email);
        signInPassword.clear();
        signInPassword.sendKeys(password);
        signInLogin.click();
    }

    public boolean isLogIn(){
        return driver.findElement(By.id("nb-1")).isDisplayed();

    }

    public void logOut(String email, String password){
        //out
        driver.findElement(By.id("nb-1")).click();
        driver.findElement(By.id("user-dropdown-popup")).click();
    }

    public boolean isLogOut(){
        return driver.findElement(By.name("login")).isDisplayed();
    }

}