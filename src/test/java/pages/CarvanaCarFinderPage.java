package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class CarvanaCarFinderPage {

  public CarvanaCarFinderPage(){
    PageFactory.initElements(Driver.getDriver(), this);
  }
  @FindBy(xpath = "//h1")
  public WebElement whatCarHeading1;

  @FindBy(css = "h3[role='presentation']")
  public WebElement carFinderHeading3;

  @FindBy(css = "a[data-qa='router-link']")
  public WebElement tryCarFinderButton;
}
