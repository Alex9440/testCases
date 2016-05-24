package bstu;

import bstu.Steps2.Steps;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Admin on 08.05.2016.
 */
public class AppTest {

    ///         https://habrahabr.ru/post/134462/

    private static final String MESSAGE = "Automation Test labs epam, bstu";

    private static final String EMAIL = "super.cool-cheese";
    private static final String PASSWORD = "Cheese!";
    private static final String SEARCH = "Cheese";;

    private Steps steps;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "login to Yandex")
    public void logIn() {
        steps.logIn(EMAIL, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn());
        steps.logOut(EMAIL, PASSWORD);
        steps.closeDriver();
        System.out.println("login to Yandex");
    }

    @Test(description = "logOut from Yandex")
    public void logOut(){
        steps.logIn(EMAIL, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn());
        steps.logOut(EMAIL, PASSWORD);
        Assert.assertTrue(steps.isLoggedOut());
        steps.closeDriver();
        System.out.println("logOut from Yandex");
    }

    @Test(description = "yandex search")
    public void search(){
        steps.search(SEARCH);
        Assert.assertTrue(steps.isFind(SEARCH));
        System.out.println("yandex search");
    }

    @Test(description = "yandex search from example")
    public void searchFromExample(){
        String ex=steps.searchFromExample();
        Assert.assertTrue(steps.isFind(ex));
        System.out.println("yandex search from example");
    }


    @Test(description = "Translate")
    public void translate() {
        steps.enterWord("Cheese");
        Assert.assertTrue(steps.isTranslated("сыр"));
        System.out.println("Translate");
    }

    @Test(description = "rus -> bel")
    public void chageLang() {
        steps.changeLang();
        Assert.assertTrue(steps.isLangChanged());
        System.out.println("Changed");
    }

    @Test(description = "ru -> en")
    public void chageLangTunepage() {
        steps.changeLangTunePage();
        Assert.assertTrue(steps.isLangChangedTunePage());
        System.out.println("Changed");
    }

    @Test(description = "chageregion")
    public void chageregion() {
        steps.changeRegion();
        Assert.assertTrue(steps.isRegionChanged());
        System.out.println("Changed");
    }

    /*@Test(description = "adv")
    public void checkadv() {
        //steps.changeRegion();
        Assert.assertTrue(steps.isAdv());
        System.out.println("adv");
    }*/

}
