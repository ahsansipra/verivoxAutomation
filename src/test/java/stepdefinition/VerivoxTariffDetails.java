package stepdefinition;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.verivox.objects.VerivoxTarfiffPage;
import com.verivox.utils.ConfigFileReader;
import com.verivox.utils.LoggingDetails;
import com.verivox.utils.WebDriverManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerivoxTariffDetails {

	WebDriver driver;
	WebElement tariffDetail;
	WebDriverWait wait;
	WebDriverManager webDriverManager;

	@Given("^the User is on www\\.verivox\\.de$")
	public void the_User_is_on_www_verivox_de() throws IOException {

		webDriverManager = WebDriverManager.getInstance();
		driver = webDriverManager.getDriver();
		driver.get(ConfigFileReader.getInstance().getApplicationUrl());

	}

	@When("^he is on the DSL calculator$")
	public void he_is_on_the_DSL_calculator() {

		VerivoxTarfiffPage.openDSLCalculator(driver).click();
		LoggingDetails.loginfo("DSL Calculator opened");

	}

	@When("^he enters prefix/code “Ihre Vorwahl” as (\\d+) with (\\d+) Mbit/s bandwidth selection$")
	public void he_enters_prefix_code_Ihre_Vorwahl_as_with_Mbit_s_bandwidth_selection(int arg1, int arg2)
			throws InterruptedException {
		Thread.sleep(3000);
		VerivoxTarfiffPage.preFixTariffForSearch(driver).click();
		VerivoxTarfiffPage.preFixTariffForSearch(driver).sendKeys("030");
		LoggingDetails.loginfo("prefix entered for tariff details");

		VerivoxTarfiffPage.bandWidthSpeedSelection(driver).click();

	}

	@When("^clicks on the button labeled as \"([^\"]*)\"$")
	public void clicks_on_the_button_labeled_as(String arg1) {

		VerivoxTarfiffPage.searchForTariffResults(driver).click();
		LoggingDetails.loginfo("fetching tariff results for prefix 030");
	}

	@Then("^he should be able see the Result List page with all the available Tariffs$")
	public void he_should_be_able_see_the_Result_List_page_with_all_the_available_Tariffs()
			throws InterruptedException {
		wait = new WebDriverWait(driver, 20);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(VerivoxTarfiffPage.openSearchedTariffForDetail(driver)));

		// available tariffs list, first page tariff details links count is given
		List<WebElement> tariffDetailsButtons = VerivoxTarfiffPage.listOfSearchedResults(driver);

		LoggingDetails.loginfo("tariffs details buttons shown are:  " + tariffDetailsButtons.size());

	}

	// second scenario Result List - verify Offer detail page

	@Given("^the User is on the DSL Result List \\(follow scenario (\\d+)\\)$")
	public void the_User_is_on_the_DSL_Result_List_follow_scenario(int arg1) {
		webDriverManager = WebDriverManager.getInstance();
		driver = webDriverManager.getDriver();
		LoggingDetails.loginfo("It will get proceeded from previous state");

	}

	@When("^he selects one of the listed Tariffs$")
	public void he_selects_one_of_the_listed_Tariffs() {
		LoggingDetails.loginfo("tariff selection and opening");
	}

	@When("^clicks on mehr zum Tarif button$")
	public void clicks_on_mehr_zum_Tarif_button() throws InterruptedException {

		Thread.sleep(3000);
		tariffDetail = VerivoxTarfiffPage.openSearchedTariffForDetail(driver);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0,-100);",
				tariffDetail);
		tariffDetail.click();

	}

	@Then("^he should be able see the details of the selected Tariff$")
	public void he_should_be_able_see_the_details_of_the_selected_Tariff() throws InterruptedException {
		Thread.sleep(2000);
		LoggingDetails.loginfo(driver.getCurrentUrl());
		String tariffAmount = VerivoxTarfiffPage.getTariffAmount(driver).getText();
		System.out.println(tariffAmount);
	}

	@SuppressWarnings("deprecation")
	@Then("^he should also see a button labeled as In (\\d+) Minuten online wechseln$")
	public void he_should_also_see_a_button_labeled_as_In_Minuten_online_wechseln(int arg1)
			throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0,-100);",
				VerivoxTarfiffPage.fiveMinuteOnline(driver));
		Assert.assertTrue(VerivoxTarfiffPage.fiveMinuteOnline(driver).isEnabled());
		LoggingDetails.loginfo("assertion done to see 5min videlo link");

	}

}
