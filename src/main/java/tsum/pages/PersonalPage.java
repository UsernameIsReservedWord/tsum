package tsum.pages;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PersonalPage {

    protected WebDriver driver;

    public PersonalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static final String phoneField = "//input[@name=\"FIELDS[PERSONAL_PHONE\"]";
    public static final String saveButton = "//span[text()='Сохранить']";
    public static final String errorField = "//div[@class='field__error']";


    // Elements
    @FindBy(xpath = phoneField)
    private WebElement phoneFieldElement;

    @FindBy(xpath = saveButton)
    private WebElement saveButtonElement;

    @FindBy(xpath = errorField)
    private List<WebElement> errorFieldElements;


    public PersonalPage setPhone(String phone) {
        phoneFieldElement.clear();
        phoneFieldElement.sendKeys(phone);
        return new PersonalPage(driver);
    }

    public String getPhone() {
        return phoneFieldElement.getText();
    }

    public PersonalPage checkPhone(String expectedPhone) {
        Assert.assertEquals("Номер телефона не совпадает", expectedPhone, getPhone());
        return new PersonalPage(driver);
    }

    public PersonalPage saveData() {
        saveButtonElement.click();
        return new PersonalPage(driver);
    }

    public PersonalPage checkError(String expectedText) {
        errorFieldElements.forEach(error->{
            if (error.isDisplayed()) {
                Assert.assertEquals("", expectedText, error.getText());
            }
        });
        return new PersonalPage(driver);
    }

}
