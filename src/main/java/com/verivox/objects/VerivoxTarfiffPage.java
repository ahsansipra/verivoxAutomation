package com.verivox.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verivox.utils.LoggingDetails;

public class VerivoxTarfiffPage {

	WebDriver driver;
	static WebElement element = null;
	static List<WebElement> tarifflist=null;

	static By dslCalculator = By.id("mps-tab-5");
	static By preFixForTarif = By.name("Prefix");
	static By bandWidthSpeed = By.xpath("(//STRONG[text()='16 '][text()='16 '])[1]");
	static By searchTariff = By
			.xpath("(//BUTTON[@class='page-button'][text()='Jetzt vergleichen'][text()='Jetzt vergleichen'])[5]");
	static By openSearchedResult = By.xpath("//*[contains(text(),'Zum Angebot')]");
	static By fiveMinuteVerify = By.xpath("(//A[@class='responsive-label-txt offer-page-cta'])[2]");
	static By nextPageResults = By.xpath("//BUTTON[contains(text(),'weitere tarife laden')]");
	static By tariffAmount = By.xpath("(//DIV[@class='centered-content effective-price-wrapper'])[1]");

	public VerivoxTarfiffPage(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement openDSLCalculator(WebDriver driver) {
		element = driver.findElement(dslCalculator);
		return element;

	}

	public static WebElement preFixTariffForSearch(WebDriver driver) {
		element = driver.findElement(preFixForTarif);
		return element;

	}

	public static WebElement bandWidthSpeedSelection(WebDriver driver) {
		element = driver.findElement(bandWidthSpeed);
		return element;

	}

	public static WebElement searchForTariffResults(WebDriver driver) {
		element = driver.findElement(searchTariff);
		return element;

	}

	public static WebElement openSearchedTariffForDetail(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		element = driver.findElement(openSearchedResult);
		return element;

	}
	
	public static List<WebElement> listOfSearchedResults(WebDriver driver) {
		tarifflist = driver.findElements(openSearchedResult);
		return tarifflist;

	}

	public static WebElement fiveMinuteOnline(WebDriver driver) {
		element = driver.findElement(fiveMinuteVerify);
		return element;

	}

	public static WebElement nextPageResultsToLoad(WebDriver driver) {
		try {
			element = driver.findElement(nextPageResults);
			return element;
		} catch (Exception e) {
			LoggingDetails.loginfo(e.getMessage());
			return null;
		}
	}

	public static WebElement getTariffAmount(WebDriver driver) {
		element = driver.findElement(tariffAmount);
		return element;

	}
}
