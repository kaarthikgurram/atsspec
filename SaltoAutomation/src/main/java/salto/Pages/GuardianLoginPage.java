package salto.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import salto.TestBase.TestBase;
import salto.Util.ReusableMethods;
import salto.Util.WaitHelper;
import salto.Util.WindowHelper;

public class GuardianLoginPage extends TestBase
{
	public static final Logger log =Logger.getLogger(GuardianLoginPage.class.getName());
	WaitHelper waithelper = new WaitHelper();
	WindowHelper windowhelper = new WindowHelper();
	ReusableMethods reuse = new ReusableMethods();
	
	@FindBy(xpath = "(//span[contains(text(),'Log In')])[1]")
	WebElement Login1;
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement enterUsername;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement enterPassword;
	
	@FindBy(xpath = "(//span[contains(text(),'Log In')])[2]")
	WebElement clickLogin;
	
	@FindBy(xpath = "(//span[contains(text(),'Dashboard')])[1]")
	WebElement dashboard;
	
	@FindBy(xpath = "//span[contains(text(),'New Project')]")
	WebElement clickNewProject;
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement projectName;
	
	@FindBy(xpath = "//input[@name='location.country.id']")
	WebElement countryDD;
	
	@FindBy(xpath = "//input[@name='location.province.id']")
	WebElement stateDD;
	
	@FindBy(xpath = "//input[@name='location.city.id']")
	WebElement cityDD;
	
	@FindBy(xpath = "//input[@name='bidDate']")
	WebElement bidDate;
	
	@FindBy(xpath = "//input[@name='area']")
	WebElement area;
	
	@FindBy(xpath = "//span[text()='Next']")
	WebElement btnNext;

	@FindBy(xpath = "(//p[text()='Education'])[1]")
	WebElement educationTile;
	
	@FindBy(xpath = "(//input[@name='FormSelectedBuildingTypesKey.2.FormSingleKey'])[1]")
	WebElement clgUniversity;
	
	@FindBy(xpath = "//span[text()='Finish']")
	WebElement finish;
	
	@FindBy(xpath = "//a[@title='Manage Projects']")
	WebElement manageProjects;
	
	@FindBy(xpath="//input[@placeholder='Enter your search']")
	WebElement search;
	
	@FindBy(xpath = "//p[contains(@class,'MuiTypography-root-932')]")
	List<WebElement> table;
	
	
	public GuardianLoginPage()
	{
		PageFactory.initElements(driver, this);
	}


	public void login() throws InterruptedException {
		reuse.click(Login1);
		waithelper.waitForElement(enterUsername, 5);
		reuse.setdata(enterUsername, "vigneshfortesting@gmail.com");
		waithelper.waitForElement(enterUsername, 5);
		reuse.setdata(enterPassword, "Test1234$");
		waithelper.waitForElement(clickLogin, 5);
		reuse.click(clickLogin);
		
	}
	
	static String projName;
	
	public void clickCreateNewProject() throws InterruptedException {
		waithelper.waitForElement(dashboard, 10);
		reuse.click(dashboard);
		reuse.click(clickNewProject);
		String[] projNameArr = reuse.generateRandomWords(1);
		projName = projNameArr[0];
		waithelper.waitForElement(projectName, 15);
		reuse.setdata(projectName, projName);		reuse.setdata(countryDD,"India");
		reuse.setdata(stateDD,"State of Tamil Nādu");
		cityDD.click();
		Thread.sleep(8000);
		cityDD.clear();
		reuse.setdata(cityDD, "Anandagirir");
//		cityDD.clear();
//		reuse.setdata(cityDD, "Anandagirir");
		Thread.sleep(5000);
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		 JavascriptExecutor jse = (JavascriptExecutor)driver;
//		 jse.executeScript("arguments[0].value='Anandagirir';", cityDD);
//		 waithelper.waitForElement(bidDate, 15);
		
		reuse.setdata(bidDate, "2022-05-26");
		reuse.setdata(area, "1200");
		reuse.click(btnNext);
		
		//Step2
		waithelper.waitForElement(educationTile, 5);
		educationTile.click();
//		waithelper.waitForElement(clgUniversity, 5);
		clgUniversity.click();
		btnNext.click();
		
		waithelper.waitForElement(finish, 5);
		finish.click();
		
		waithelper.waitForElement(manageProjects, 5);
		JavascriptExecutor executor = (JavascriptExecutor)driver; executor. executeScript("arguments[0]. click();", manageProjects);
		
		waithelper.waitForElement(search, 5);
		for(WebElement ele : table)
		{
			if(ele.getText().equals(projName))
			{
				ele.click();
				break;
			}
		}
		
	}
	
}

