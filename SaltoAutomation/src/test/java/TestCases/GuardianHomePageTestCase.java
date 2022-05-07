package TestCases;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import salto.Pages.GuardianHomePage;
import salto.Pages.GuardianLoginPage;
import salto.TestBase.TestBase;
import salto.Util.ExcelHelper;
import salto.Util.ReusableMethods;
import salto.Util.WindowHelper;

public class GuardianHomePageTestCase extends TestBase
{
	public static final Logger log =Logger.getLogger(GuardianHomePageTestCase.class.getName());
	GuardianHomePage guardianhomepage;
	GuardianLoginPage guardianloginpage;
	ExcelHelper excelhelper;
	

	String ExcelPath=System.getProperty("user.dir")+"\\src\\main\\java\\salto\\Data\\GoldSalto.xlsx";
	String SheetName="Selenium_Test";
	
	
	public GuardianHomePageTestCase()
	{
		super();
	}
	
	@BeforeTest
	public void Init() throws InterruptedException, AddressException, InvalidFormatException, IOException, MessagingException
	{
		initialization();
		guardianloginpage=new GuardianLoginPage();
		guardianhomepage=new GuardianHomePage();
		excelhelper = new ExcelHelper();
	}
	@DataProvider
	public Object[][] ExcelRead(){
		Object data[][] = ExcelHelper.getTestDataExcel(ExcelPath,SheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider="ExcelRead")
	public void Launch_Guardian_Application(String emailId,String firstname, String lastname, String pwd, String confirmpassword) throws InterruptedException
	{
		
		guardianhomepage.signup(emailId, firstname, lastname, pwd, confirmpassword);
		guardianhomepage.basicOrganizationDetails();
		guardianhomepage.clickSignUp();
		guardianhomepage.validateActivateAccount();
		
		
	}
	
	@Test(priority=2)
	public void login_application() throws InterruptedException
	{
		
		guardianloginpage.login();
		guardianloginpage.clickCreateNewProject();
		
	}
	
	
	
}

