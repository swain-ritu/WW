/**
 * 
 */
package webProject_pkg;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.*;
import org.openqa.selenium.Keys;
/**
 * Test for finding page title
 *
 */
public class WWTest {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C://ProgramData/chromedriver.exe");
		WebDriver d = new ChromeDriver();
		JavascriptExecutor js= (JavascriptExecutor)d;
		Actions builder= new Actions(d);
		
		d.get("https://www.weightwatchers.com/us/");
		String s= d.getTitle();
		Assert.assertEquals(s, "WW (Weight Watchers): Weight Loss & Wellness Help");
		// the title given to test "Weight Loss Program, Recipes & Help | Weight Watchers" is incorrect
		WebElement meeting= d.findElement(By.className("find-a-meeting"));
		meeting.click();
		String m=d.getTitle();
		Assert.assertEquals(m, "Find WW Studios & Meetings Near You | WW USA");
		// again the title is not "Get Schedules & Times Near You"
		
		WebElement zip= d.findElement(By.id("meetingSearch"));
		zip.click();
		
		
		WebElement w= d.findElement(By.cssSelector(".spice-translated"));
		
		js.executeScript("document.getElementById('meetingSearch').value='10011';", zip);
		Thread.sleep(5000);
		//WebElement w= d.findElement(By.cssSelector(".btn.spice-translated"));
		js.executeScript("arguments[0].click();", w);
		//builder.moveToElement(w).click().build().perform();
		
		
		d.close();
	
		
	}

}
