package tsum.tests;

import net.bytebuddy.utility.RandomString;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tsum.Config;
import tsum.pages.Page;

@RunWith(SerenityRunner.class)
public class PageTest {

	private Page mainPage;

	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new Base().setDriver();
		mainPage = new Page(driver);
		mainPage.navigate();
	}

	@After
    public void afterTest() {
	    driver.quit();
    }

	@Test
	public void incorrectLoginTest() {
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