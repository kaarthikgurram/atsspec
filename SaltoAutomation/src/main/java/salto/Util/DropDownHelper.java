package salto.Util;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import salto.TestBase.TestBase;



public class DropDownHelper extends TestBase{

	
  
	public static final Logger log =Logger.getLogger(DropDownHelper.class.getName());
	
		
	public void selectUsingValue(WebElement element, String value){
		Select select = new Select(element);
		log.info("selectUsingValue and value is: "+value);
		select.selectByValue(value);
	}
	
	public void selectUsingIndex(WebElement element, int index){
		Select select = new Select(element);
		log.info("selectUsingIndex and index is: "+index);
		select.selectByIndex(index);
	}
	
	public void selectUsingVisibleText(WebElement element, String visibleText) throws InterruptedException{
		Select select = new Select(element);
		log.info("selectUsingVisibleText and visibleText is: "+visibleText);
		select.selectByVisibleText(visibleText);
		Thread.sleep(3000);
	}
	
	public void deSelectUsingValue(WebElement element, String value){
		Select select = new Select(element);
		log.info("deSelectUsingValue and value is: "+value);
		select.deselectByValue(value);
	}
	
	public void deSelectUsingIndex(WebElement element, int index){
		Select select = new Select(element);
		log.info("deSelectUsingIndex and index is: "+index);
		select.deselectByIndex(index);
	}
	
	public void deSelectUsingVisibleText(WebElement element, String visibleText){
		Select select = new Select(element);
		log.info("deselectByVisibleText and visibleText is: "+visibleText);
		select.deselectByVisibleText(visibleText);
	}
	
	public List<String> getAllDropDownData(WebElement element){
		Select select = new Select(element);
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		for(WebElement ele: elementList){
			log.info(ele.getText());
			valueList.add(ele.getText());
		}
		return valueList;
		
	
}
	
	public void MoveToTaskandClick(WebElement ele)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).perform();
		ac.click().build().perform();
				
	}
	
	public void MoveToTaskandDoubleClick(WebElement ele) throws InterruptedException
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).perform();
		ac.doubleClick().build().perform();
		//Thread.sleep(3000);
	}
	
	
	public void moveTillSubTaskandClick(WebElement ele1,WebElement ele2) throws InterruptedException
	{
		Actions ac = new Actions(driver);
		log.info("Task Link is: "+ele1);
		ac.moveToElement(ele1).click();
		ac.moveToElement(ele2);
		ac.click().build().perform();	
		Thread.sleep(5000);
	}
	public void moveToTask(WebElement ele1)
	{
		Actions ac = new Actions(driver);
		log.info("Task Link is: "+ele1);
		ac.moveToElement(ele1);
		log.info("Moved to Element by action using class");
	}
	

}
