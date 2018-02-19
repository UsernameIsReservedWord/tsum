package tsum.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.commons.lang3.RandomUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tsum.Config;
import tsum.pages.Page;
import tsum.pages.PersonalPage;

@RunWith(SerenityRunner.class)
public class PersonalPageTest {

	private Page mainPage;
	private PersonalPage personalPage;

	private WebDriver driver;

	@Before
	public void beforeTest() {
		driver = new Base().setDriver();
		mainPage = new Page(driver);
		personalPage = new PersonalPage(driver);
		mainPage.navigate()
				.openLoginPopUp()
				.setLogin(Config.get("defaultLogin"))
				.setPassword(Config.get("defaultPassword"))
				.auth();
	}

	@After
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void updatePhoneNumberCorrect() {
		String newPhone = String.format("7900%s", RandomUtils.nextInt(1000000, 9999999));
		personalPage
				.setPhone(newPhone)
				.saveData()
				.checkPhone(newPhone);
	}

	@Test
	public void updatePhoneEmptyField() {
		String oldNumber = personalPage.getPhone();
		personalPage
				.setPhone("")
				.saveData()
				.checkError("Введите номер")
				.checkPhone(oldNumber);
	}

 }
