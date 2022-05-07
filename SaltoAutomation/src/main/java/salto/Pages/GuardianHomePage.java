package salto.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import salto.TestBase.TestBase;
import salto.Util.DropDownHelper;
import salto.Util.ReusableMethods;
import salto.Util.WaitHelper;
import salto.Util.WindowHelper;

public class GuardianHomePage extends TestBase 
{
	public static final Logger log =Logger.getLogger(GuardianHomePage.class.getName());
	WaitHelper waithelper = new WaitHelper();
	WindowHelper windowhelper= new WindowHelper();
	ReusableMethods reuse = new ReusableMethods();
	DropDownHelper dropdownhelper = new DropDownHelper();
	
	@FindBy(xpath = "//span[contains(text(),'Sign Up')]")
	public WebElement signUp;
	
	@FindBy(xpath = "//input[contains(@name,'email')]")
	public WebElement email;
	
	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input')])[2]")
	public WebElement fname;
	
	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input')])[3]")
	public WebElement lname;
	
	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input')])[4]")
	public WebElement password;
	
	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input')])[5]")
	public WebElement confirmpassword;
	
	@FindBy(xpath = "//span[contains(text(),'continue')]")
	public WebElement continue1;
	
	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input-681 MuiInput-input-666')])[1]")
	public WebElement companyName;
	
	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input-681 MuiInput-input-666')])[2]")
	public WebElement companyAddress;
	
	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input-681 MuiInput-input-666')])[3]")
	public WebElement country;
	
	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input-681 MuiInput-input-666')])[4]")
	public WebElement state;
	
	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input-681 MuiInput-input-666')])[5]")
	public WebElement city;
	
	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input-681 MuiInput-input-666')])[6]")
	public WebElement Postalcode;
	
	@FindBy(xpath = "//div[contains(@id,'mui-component-select-firmTypeId')]")
	public WebElement OrganizationType;
	
	@FindBy(xpath = "(//li[contains(@class,'MuiButtonBase-root')])[1]")
	public WebElement OrganizationTypeValue;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	public WebElement Next;
	
	@FindBy(xpath = "//span[contains(text(),'sign up')]")
	public WebElement signup;
	
	@FindBy(linkText = "https://accounts.google.com/signin")
	public WebElement launch;
	
	public GuardianHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void signup(String emailId,String firstname,String lastname, String pwd, String confirmPassword) throws InterruptedException {
		reuse.click(signUp);
		reuse.setdata(email, emailId);
		reuse.setdata(fname, firstname);
		reuse.setdata(lname, lastname);
		reuse.setdata(password, pwd);
		reuse.setdata(confirmpassword, confirmPassword);
		reuse.click(continue1);
		Thread.sleep(3000);
		
	}
	
	public void basicOrganizationDetails() throws InterruptedException {
		waithelper.waitForElement(companyName, 10);
		reuse.setdata(companyName, "Test Organization");
		waithelper.waitForElement(companyAddress, 10);
		reuse.setdata(companyAddress, "43.old street");
		waithelper.waitForElement(country, 10);
		reuse.setdata(country, "United States");
		waithelper.waitForElement(state, 10);
		reuse.setdata(state, "Washington");
		waithelper.waitForElement(city, 10);
		reuse.setdata(city, "Sara");
		waithelper.waitForElement(Postalcode, 10);
		reuse.setdata(Postalcode, "12345");
		reuse.click(OrganizationType);
		waithelper.waitForElement(OrganizationTypeValue, 5);
		reuse.click(OrganizationTypeValue);
		waithelper.waitForElement(Next, 10);
		reuse.click(Next);
	}
	
	public void clickSignUp() throws InterruptedException {
		
		waithelper.waitForElement(signup, 10);
		reuse.click(signup);
	}
	
	public void validateActivateAccount() throws InterruptedException {
		
		/*String gmailurl = prop.getProperty("gmail_url");
		driver.get(gmailurl);
		driver.manage().window().maximize();*/
			windowhelper.SwitchMultipleWindow("Sign in- Google account");
			reuse.click(launch);
			//reuse.click(UserPortalLink);
			windowhelper.SwitchMultipleWindow("Sign in- Google accounts");
		}
	}
	

