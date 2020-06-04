package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.mk_latn.No;

public class AmazonProject {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("twotabsearchtextbox").sendKeys("oneplus 7 pro mobiles");
		driver.findElementByXPath("//input[@type='submit']").click();
		WebElement firstmobile = driver.findElementByXPath("(//span[@class='a-price-whole'])[1]");
		String first = firstmobile.getText();
		System.out.println("first mobile price :"+first);
		driver.findElementByXPath("(//img[@class='s-image'])[1]").click();

		Set<String> set = driver.getWindowHandles();
		List<String> one =new ArrayList<String>(set);
		driver.switchTo().window(one.get(1));
		WebElement rate = driver.findElementByXPath("(//span[@class='a-size-base a-color-secondary'])[3]");
		String text = rate.getText();

		System.out.println("No.of rating customer :"+text);
		driver.findElementByXPath("//input[@id='add-to-cart-button']").click();
		WebElement add = driver.findElementByXPath("(//h4[@class='a-alert-heading'])[3]");
		String added = add.getText();
		System.out.println("confirmatiom :"+added);

		driver.findElementByXPath("(//input[@class='a-button-input'])[5]").click();
		String title = driver.getTitle();
		System.out.println("name of the page :"+title);
		driver.findElementById("continue").click();
		WebElement chumma = driver.findElementByXPath("(//div[@class='a-alert-content'])[2]");
		String text2 = chumma.getText();
		System.err.println("whAT HAPPENS :"+text2);
		driver.close();


	}


}
