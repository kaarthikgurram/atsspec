package salto.Util;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import salto.TestBase.TestBase;


public class AlertHelper extends TestBase{

	public static final Logger log =Logger.getLogger(AlertHelper.class.getName());
	
	
	public Alert getAlert(){
		log.info("alert test: "+driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	
	public void acceptAlert(){
		getAlert().accept();
		log.info("accept Alert is done...");
	}
	
	public void dismissAlert(){
		getAlert().dismiss();
		log.info("dismiss Alert is done...");
	}
	
	public String getAlertText(){
		String text = getAlert().getText();
		log.info("alert text: "+text);
		return text;
	}
	
	public boolean isAlertPresent(){
		try{
			driver.switchTo().alert();
			log.info("alert is present");
			return true;
		}
		catch(NoAlertPresentException e){
			log.info(e.getCause());
			return false;
		}
	}
	
	public void acceptAlertIfPresent() throws InterruptedException{
		if(isAlertPresent()){
			acceptAlert();
			Thread.sleep(4000);
		}
		else{
			log.info("Alert is not present..");
		}
	}
	
	public void dismissAlertIfPresent() throws InterruptedException{
		if(isAlertPresent()){
			dismissAlert();
			Thread.sleep(3000);
		}
		else{
			log.info("Alert is not present..");
		}
	}
	
	public void acceptPrompt(String text){
		if(isAlertPresent()){
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("alert text: "+text);
		}
	}
}
