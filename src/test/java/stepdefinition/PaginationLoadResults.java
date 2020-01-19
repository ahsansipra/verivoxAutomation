package stepdefinition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verivox.objects.VerivoxTarfiffPage;
import com.verivox.utils.LoggingDetails;
import com.verivox.utils.WebDriverManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("deprecation")
public class PaginationLoadResults {

	WebDriver driver;
	WebDriverManager webDriverManager;

	@Given("^the User is on the DSL Result List as in scenario (\\d+)$")
	public void the_User_is_on_the_DSL_Result_List_as_in_scenario(int arg1) {
		// driver = getDriver();
		webDriverManager = WebDriverManager.getInstance();
		driver = webDriverManager.getDriver();
		driver.navigate().to("https://www.verivox.de/internet/vergleich/#/030/16000");

	}

	@When("^there are more than (\\d+) tariffs available for the provided Vorwahl and bandwidth$")
	public void there_are_more_than_tariffs_available_for_the_provided_Vorwahl_and_bandwidth(int arg1) {
		LoggingDetails.loginfo("in next step conditions will be checked");
	}

	@Then("^the User should a button labeled as (\\d+) weitere laden$")
	public void the_User_should_a_button_labeled_as_weitere_laden(int arg1) throws InterruptedException {

		int i = 0;

		do {
			Thread.sleep(3000);
			WebElement nextRecords = VerivoxTarfiffPage.nextPageResultsToLoad(driver);
			if (nextRecords != null && nextRecords.isDisplayed()) {

				((JavascriptExecutor) driver)
						.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0,-100);", nextRecords);
				// VerivoxTarfiffPage.nextPageResultsToLoad(driver).click();
				nextRecords.click();
			} else {
				LoggingDetails.loginfo("no more data to load");
				break;
			}

			i++;
		} while (i <= 10);

	}

	@Then("^WHEN he/she clicks on this button$")
	public void when_he_she_clicks_on_this_button() {
		LoggingDetails.loginfo("all result list is fetched");

	}

	@SuppressWarnings("deprecation")
	@Then("^the list should be appended with next (\\d+) tariffs and so on until all Tariffs are loaded$")
	public void the_list_should_be_appended_with_next_tariffs_and_so_on_until_all_Tariffs_are_loaded(int arg1) {

		LoggingDetails.loginfo("all tariff results loaded");
		// Assert.assertFalse(VerivoxTarfiffPage.nextPageResultsToLoad(driver).isDisplayed());

		webDriverManager.closeDriver();
	}

}
