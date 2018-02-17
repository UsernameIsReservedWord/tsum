package tsum.tests;

import net.bytebuddy.utility.RandomString;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tsum.Config;
import tsum.pages.Page;

class PageTest extends Base {
	private Page mainPage;
	private FirefoxDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
		driver = new FirefoxDriver();
		mainPage = new Page(driver);
	}

	@Before
	void beforeTest() {
		driver.get(Config.get("url"));
	}

	@Test
	void correctLogin() {
		mainPage
			.openLoginPopUp()
			.setLogin(RandomString.make())
			.setPassword("Test12345")
			.auth()
			.checkError("Указан некорректный email")
		;
	}
}