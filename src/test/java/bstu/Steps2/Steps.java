package bstu.Steps2;

import bstu.page2.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;




public class Steps {
    private WebDriver driver;
    public void initBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    public void closeDriver()
    {
        driver.close();
    }


    public void logIn(String username, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage("http://mail.yandex.by/");
        loginPage.logIn(username, password);
    }
    public boolean isLoggedIn()
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.isLogIn());
    }
    public void logOut(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage("http://mail.yandex.by/");
        loginPage.logOut(username,password);
    }
    public boolean isLoggedOut()
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.isLogOut());
    }

    public void search(String searchC){
        Search search = new Search(driver);
        search.openPage("https://yandex.by/");
        search.search(searchC);
    }
    public boolean isFind(String searchC)
    {
        Search search = new Search(driver);
        return (search.isFind(searchC));
    }

    public String searchFromExample(){
        Search search = new Search(driver);
        search.openPage("https://yandex.by/");
        return search.searchFromExample();
    }


    public void enterWord(String textEng)
    {
        TranslatePage s = new TranslatePage(driver);
        s.openPage("https://translate.yandex.by/");
        s.translate(textEng);
    }

    public boolean isTranslated(String textRus)
    {
        TranslatePage s = new TranslatePage(driver);
        return s.isTranslated(textRus);
    }

    public void changeLang()
    {
        Search s = new Search(driver);
        s.openPage("https://yandex.by/");
        s.ChangeLang();
    }

    public boolean isLangChanged()
    {
        Search s = new Search(driver);
        return s.isLangChange();
    }

    public void changeLangTunePage()
    {
        TunePage s = new TunePage(driver);
        s.openPage("https://tune.yandex.by/");
        s.ChangeLang();
    }

    public boolean isLangChangedTunePage()
    {
        TunePage s = new TunePage(driver);
        return s.isLangChange();
    }

    public void changeRegion()
    {
        TunePage s = new TunePage(driver);
        s.openPage("https://yandex.by/");
        //s.openPage("https://tune.yandex.by/region/");
        s.ChangeRegion();

    }

    public boolean isRegionChanged()
    {
        TunePage s = new TunePage(driver);
        //s.openPage("https://tune.yandex.by/region/");
        return s.isRegionChanged();
    }

    /*public boolean isAdv()
    {
        Search s = new Search(driver);
        s.openPage("https://yandex.by/");
        return s.isAdv();
    }*/
}


