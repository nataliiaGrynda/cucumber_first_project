package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utility.Driver;

public class Hooks {
  //we cannot use this with api or html driver
  @After
  public void teardown(Scenario scenario){
    System.out.println("Scenario = " + scenario.getName() + "\nstatus = " +  scenario.getStatus());
    try{
      if(scenario.isFailed()){
        byte[] screenshot = ((TakesScreenshot) Driver.getDriver())
          .getScreenshotAs(OutputType.BYTES);

        scenario.embed(screenshot, "image/png");
      }
    }catch (Exception e){
      e.printStackTrace();
    }
    finally {
      Driver.quitDriver();
    }
  }
}
