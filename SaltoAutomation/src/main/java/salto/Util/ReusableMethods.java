package salto.Util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import salto.TestBase.TestBase;

import java.nio.file.*;


public class ReusableMethods extends TestBase
{
	public static final Logger log =Logger.getLogger(ReusableMethods.class.getName());
	
	JavaScriptHelper javascripthelper = new JavaScriptHelper();
	WindowHelper windowhelper = new WindowHelper();
	
	public void checkColumnNamesAndCount(List<WebElement> ele) throws IOException
	{
		try
		{
			
			log.info(" NO of COlumns : "+ele.size());
			for(WebElement list : ele)
			{
				log.info("List Of Columns are::::"+list.getText());	
			}
		}
		catch(StaleElementReferenceException ex) 
		{
			log.info(ex.getMessage());
		}	
	}
	
	public void selectAllCheckbox(List<WebElement> ele) throws IOException
	{
		/*try
		{*/
			
			log.info(" NO of Checkboxes : "+ele.size());
			
			Iterator<WebElement> ir = ele.iterator();
			
			while(ir.hasNext())
			{
				if(ir.next().isDisplayed())
				{
					ir.next().click();
				}
			}
		/*catch(StaleElementReferenceException ex) 
		{
			log.info(ex.getMessage());
		}	*/
	}
	public void takeScreenshot(String FileName) throws IOException
	{
		Path screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE).toPath();
		System.out.println("screenshot done");
		BufferedImage img = ImageIO.read(screen.toFile());
		ImageIO.write(img, "jpg", screen.toFile()); 
		String currentDir1 = System.getProperty("user.dir");
		String filenamewithtime =  new SimpleDateFormat("yyyy-MM-dd HH-mm-ss'.txt'").format(new Date());
		File dest=new File(currentDir1 + "/ApplicationScreenshots/" + FileName + "_"+filenamewithtime + ".jpg");
		Files.copy(screen, dest.toPath());
		System.out.println("image copied");  
	}
	
	public static String getLatestFile() throws IOException
	{
		String currentDir1 = System.getProperty("user.dir");
		Path path = Files.walk(Paths.get(currentDir1+"//reports"))
		.filter(Files::isRegularFile).sorted((x,y)->
		{ int val = 0;
			try {
				val = -(new Date(Files.getLastModifiedTime(x).toMillis()).compareTo(new Date(Files.getLastModifiedTime(y).toMillis())));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return val;
		}).findFirst().get();
		return path.toString();
}
	public void click(WebElement ele) throws InterruptedException
	{
		ele.click();
		Thread.sleep(5000);
	}
	public void setdata(WebElement ele,String data) throws InterruptedException
	{
		ele.sendKeys(data);
		Thread.sleep(3000);
		log.info("Value as "+data+"is set to Element"+ele);
	}
	public void closeTabInSalto(WebElement ele) throws InterruptedException
	{
		windowhelper.switchToParentWindow();
		javascripthelper.clickElement(ele);
		Thread.sleep(5000);
		
	}
	public void closeBothTabsInSalto(WebElement ele1,WebElement ele2) throws InterruptedException
	{
		windowhelper.switchToParentWindow();
		javascripthelper.clickElement(ele1);
		Thread.sleep(5000);
		javascripthelper.clickElement(ele2);
	}
	
	public static String[] generateRandomWords(int numberOfWords)
	{
	    String[] randomStrings = new String[numberOfWords];
	    Random random = new Random();
	    for(int i = 0; i < numberOfWords; i++)
	    {
	        char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
	        for(int j = 0; j < word.length; j++)
	        {
	            word[j] = (char)('a' + random.nextInt(26));
	        }
	        randomStrings[i] = new String(word);
	    }
	    return randomStrings;
	}
	
}
