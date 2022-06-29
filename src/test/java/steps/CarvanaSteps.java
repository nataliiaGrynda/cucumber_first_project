package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;
import utility.ActionUtil;
import utility.Driver;
import utility.DropDownHandler;
import utility.Waiter;

public class CarvanaSteps {

  WebDriver driver;
  CarvanaHomePage carvanaHomePage;
  CarvanaAttributesPage carvanaAttributesPage;
  CarvanaCarFinderPage carvanaCarFinderPage;
  SellMyCarPage sellMyCarPage;
  CarvanaLoanCalculatorPage carvanaLoanCalculatorPage;

  @Before
  public void setup(){
    driver = Driver.getDriver();
    carvanaHomePage = new CarvanaHomePage();
    carvanaAttributesPage = new CarvanaAttributesPage();
    carvanaCarFinderPage = new CarvanaCarFinderPage();
    sellMyCarPage = new SellMyCarPage();
 carvanaLoanCalculatorPage = new CarvanaLoanCalculatorPage();

  }
  @Given("user is on {string}")
  public void userIsOn(String url) {
    driver.get(url);
  }

  @When("user clicks on {string}")
  public void userClicksOn(String carFinder) {
    Assert.assertTrue(carvanaHomePage.carFinderLink.isDisplayed());
    carvanaHomePage.carFinderLink.click();
  }

  @Then("user should be navigated to {string}")
  public void userShouldBeNavigatedTo(String url) {
    switch (url) {
      case "https://www.carvana.com/help-me-search/":
      case "https://www.carvana.com/help-me-search/qa":
      case "https://www.carvana.com/sell-my-car":
        Assert.assertEquals(url, driver.getCurrentUrl());
        break;
    }
  }

  @And("user should see {string} text")
  public void userShouldSeeText(String headingText) {
    switch (headingText) {
      case "https://www.carvana.com/help-me-search/":
        Assert.assertTrue(carvanaCarFinderPage.whatCarHeading1.isDisplayed());
        Assert.assertEquals(headingText, carvanaCarFinderPage.whatCarHeading1.getText());
        Assert.assertTrue(carvanaCarFinderPage.carFinderHeading3.isDisplayed());
        Assert.assertEquals(headingText, carvanaCarFinderPage.carFinderHeading3.getText());
        break;
      case "https://www.carvana.com/help-me-search/qa":
        Assert.assertTrue(carvanaAttributesPage.headlineText.isDisplayed());
        Assert.assertEquals(headingText, carvanaAttributesPage.headlineText.getText());
        Assert.assertTrue(carvanaAttributesPage.subHeadingText.isDisplayed());
        Assert.assertEquals(headingText, carvanaAttributesPage.subHeadingText.getText());
        break;
      case "https://www.carvana.com/sell-my-car":
        Assert.assertTrue(sellMyCarPage.getOfferText.isDisplayed());
        Assert.assertEquals(headingText, sellMyCarPage.getOfferText.getText());
        Assert.assertTrue(sellMyCarPage.wePickYourCarText.isDisplayed());
        Assert.assertEquals(headingText, sellMyCarPage.wePickYourCarText.getText());
        Assert.assertTrue(sellMyCarPage.weFoundYourPinText.isDisplayed());
        Waiter.waitUntilTextToBePresentInElement(driver, 3, sellMyCarPage.weFoundYourPinText,headingText);
        Assert.assertEquals(headingText, sellMyCarPage.weFoundYourPinText.getText());
        break;
    }
  }

  @And("user should see {string} link")
  public void userShouldSeeLink(String link) {
    Assert.assertTrue(carvanaCarFinderPage.tryCarFinderButton.isDisplayed());
    Assert.assertEquals(link, carvanaCarFinderPage.tryCarFinderButton.getText());


  }

  @When("user clicks on {string} link")
  public void userClicksOnLink(String link) {
    if ("TRY CAR FINDER".equals(link)) {
      carvanaCarFinderPage.tryCarFinderButton.click();
    }
  }

  @When("user clicks on {string} menu item")
  public void userClicksOnMenuItem(String arg0) {
  }

  @When("user clicks on {string} button")
  public void userClicksOnButton(String button) {
    switch (button) {
      case "VIN":
        Waiter.pause(2);
        sellMyCarPage.vinButton.click();
        break;
      case "GET MY OFFER":
        sellMyCarPage.OfferButton.click();
        break;
    }

  }

  @And("user enters vin number as {string}")
  public void userEntersVinNumberAs(String vinNumber) {
    sellMyCarPage.vinInputBox.sendKeys(vinNumber);

  }

  @When("user hovers over on {string} menu item")
  public void userHoversOverOnMenuItem(String buttonText) {
    Assert.assertEquals(buttonText,carvanaHomePage.financingMenuButton.getText());
    Waiter.pause(2);
    ActionUtil.moveToElement(carvanaHomePage.financingMenuButton);
  }

  @When("user enters {string} as {string}")
  public void userEntersAs(String costText, String cost) {
    switch (costText){
      case "Cost of Car I want":
        Assert.assertTrue(costText,carvanaLoanCalculatorPage.costOfCarInputBox.isDisplayed());
        carvanaLoanCalculatorPage.costOfCarInputBox.sendKeys(cost);
        break;
      case "What is Your Down Payment?":
        carvanaLoanCalculatorPage.downPayment.sendKeys(cost);
        break;
    }
  }

  @And("user selects {string} as {string}")
  public void userSelectsAs(String scoreText, String score) {
    switch (scoreText) {
      case "What’s Your credit Score?":
        DropDownHandler.selectOptionByIndex(carvanaLoanCalculatorPage.creditScoreBox, 0);
        break;
      case "Choose Your Loan Terms":
        Waiter.pause(2);
        DropDownHandler.selectOptionByIndex(carvanaLoanCalculatorPage.loanTerm,1);
        break;
    }
  }
  @Then("user should see the monthly payment as {string}")
  public void userShouldSeeTheMonthlyPaymentAs(String payment) {
  Assert.assertTrue(carvanaLoanCalculatorPage.monthlyPayment.isDisplayed());
  Assert.assertEquals(payment,carvanaLoanCalculatorPage.monthlyPayment.getText());
  }
}
