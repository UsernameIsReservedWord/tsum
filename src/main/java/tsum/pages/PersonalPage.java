package tsum.pages;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalPage {

    protected WebDriver driver;

    public PersonalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static final String phoneField = "//input[@name=\"FIELDS[PERSONAL_PHONE\"]";
    public static final String saveButton = "//span[text()='Сохранить']";


    // Elements
    @FindBy(xpath = phoneField)
    private WebElement phoneFieldElement;

    @FindBy(xpath = saveButton)
    private WebElement saveButtonElement;


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

}
