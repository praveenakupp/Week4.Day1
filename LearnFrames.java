package Week4.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {

	public static void main(String[] args)
	{
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement frame1=driver.findElement(By.xpath("(//div[@id='iframewrapper'])/iframe"));
	driver.switchTo().frame(frame1);
	driver.findElementByXPath("//button[text()='Try it']").click();
	Alert alert=driver.switchTo().alert();
	alert.dismiss();
	String str=driver.findElementById("demo").getText();
	if (str.contains("OK"))
	{
		System.out.println("you pressed OK");
	}
	else
		System.out.println("you pressed Cancel");
	}
			
}
