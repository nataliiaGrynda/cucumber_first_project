package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtil {

  private static Actions actions;

  static{
    actions = new Actions(Driver.getDriver());
  }


  public static void rightClick(WebElement element){
    actions.contextClick(element).perform();
  }

  public static void moveToElement(WebElement element){
    actions.moveToElement(element).perform();
  }
}

 /*
  public static void rightClick(WebElement element){
    new Actions(Driver.getDriver()).contextClick(element).perform();
  }

public static void moveToElement(WebElement element){
    new Actions(Driver.getDriver()).moveToElement(element).perform();
}
}
*/

