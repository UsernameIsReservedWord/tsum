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

@RunWith(SerenityRunner.class)
public class PageTest {

	private static Page mainPage;

	private static WebDriver driver;

	@BeforeClass
	public static void beforeTest() {
	    driver = new Base().setDriver();
		mainPage = new Page(driver);
		driver.get("https://www.tsum.ru/");
	}

	@After
    public void afterTest() {
	    driver.quit();
    }

	@Test
	public void incorrectLoginTest() {
	    driver.get("https://www.tsum.ru/");
        mainPage
			.openLoginPopUp()
			.setLogin(RandomString.make())
			.setPassword("Test12345")
			.auth()
			.checkError("Указан некорректный email")
		;
	}

	@Test
	public void successAuthTest() {
		mainPage
            .openLoginPopUp()
			.setLogin(Config.get("defaultLogin"))
			.setPassword(Config.get("defaultPassword"))
            .auth()
            .checkProfileLinkText("Тест")
				;
	}
}