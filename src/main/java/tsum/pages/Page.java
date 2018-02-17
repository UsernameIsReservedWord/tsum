package tsum.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public static final String loginButton = "//a[.='Личный кабинет']";
    public static final String loginField = "//input[@name='email']";
    public static final String passwordField = "//input[@name='password']";
    public static final String authButton = "//button[@type='submit']/span[.='Войти']";
    public static final String errorField = "//div[@class='field__error']";
    public static final String loginErrors = "//div[contains(@class, 'js-field-custom-email')]/div[@class=\"field__error\"]";

    // Elemtns
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

    public Page openLoginPopUp() {
        loginButtonElement.click();
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

}
