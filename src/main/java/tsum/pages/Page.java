package tsum.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.reports.adaptors.specflow.ScenarioStep;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tsum.Config;

import java.util.List;


public class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static final String loginButton = "//a[text()=\"Личный кабинет\"]";
    public static final String loginField = "//input[@name='email']";
    public static final String passwordField = "//input[@name='password']";
    public static final String authButton = "//button[@type='submit']/span[.='Войти']";
    public static final String errorField = "//div[@class='field__error']";
    public static final String loginErrors = "//div[contains(@class, 'js-field-custom-email')]/div[@class=\"field__error\"]";
    public static final String profileLink = "//a[@href=\"/personal/profile/\"]";

    // Elements
    @FindBy(xpath = loginButton)
    private WebElement loginButtonElement;

    @FindBy(xpath = loginField)
    private WebElement loginFieldElement;

    @FindBy(xpath = passwordField)
    private WebElement passwordFieldElement;

    @FindBy(xpath = authButton)
    private WebElement authElement;

    @FindBy(xpath = loginErrors)
    private WebElement loginErrorElement;

    @FindBy(xpath = errorField)
    private List<WebElement> errorElements;

    @FindBy(xpath = profileLink)
    private WebElement profileLinkElement;

    public Page openLoginPopUp() {
        loginButtonElement.click();
        return new Page(driver);
    }

    public Page navigateToPersonalPage() {
        profileLinkElement.click();
        return new Page(driver);
    }

    public Page setLogin(String login) {
        loginFieldElement.sendKeys(login);
        return new Page(driver);
    }

    public Page setPassword(String password) {
        passwordFieldElement.sendKeys(password);
        return new Page(driver);
    }

    public Page auth() {
        authElement.click();
        return new Page(driver);
    }

    public Page checkError(String expectedText) {
        errorElements.forEach(error->{
            if (error.isDisplayed()) {
                Assert.assertEquals("", expectedText, error.getText());
            }
        });
        return new Page(driver);
    }

    public Page checkProfileLinkText(String expectedName) {
        Assert.assertEquals("", expectedName, profileLinkElement.getText());
        return new Page(driver);
    }

    public Page navigate() {
        driver.get(Config.get("url"));
        return new Page(driver);
    }
}
