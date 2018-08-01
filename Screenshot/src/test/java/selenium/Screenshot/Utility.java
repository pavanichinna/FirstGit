package selenium.Screenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utility {
	
	public static WebDriver driver;
	
	public static void initialization() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\Screenshot\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void failed(String testMethodName) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\Users\\user\\eclipse-workspace\\Screenshot\\screenshot\\"+testMethodName+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
