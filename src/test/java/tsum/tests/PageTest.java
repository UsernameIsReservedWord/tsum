package tsum.tests;

import net.bytebuddy.utility.RandomString;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tsum.Config;
import tsum.pages.Page;

//@RunWith(SerenityRunner.class)
public class PageTest extends Base {

	@Steps
	private Page mainPage;

	private WebDriver driver;

	@Before
	public void beforeTest() {
		setDriver();
		driver = new FirefoxDriver();
		mainPage = new Page(driver);
		driver.get(Config.get("url"));
	}

	@After
    public void afterTest() {
	    driver.quit();
    }

	@Test
	public void correctLogin() {
		mainPage
			.openLoginPopUp()
			.setLogin(RandomString.make())
			.setPassword("Test12345")
			.auth()
			.checkError("Указан некорректный email")
		;
	}
}