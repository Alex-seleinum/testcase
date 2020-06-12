package bigBasket;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class steps {
	ChromeDriver driver;
	Actions action;
	JavascriptExecutor js;

		@Given("User launches the browser for Big Basket")
		public void user_launches_the_browser_for_Big_Basket1() {
			//	1) Go to https://www.bigbasket.com/
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver1.exe");
			driver=new ChromeDriver();
			driver.get("https://www.bigbasket.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			ChromeOptions options =new ChromeOptions();
			options.addArguments("--disable-notifications");
		}

		@Given("User loads the BigBasket application")
		public void user_loads_the_BigBasket_application1() {
			driver.get("https://www.bigbasket.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			ChromeOptions options =new ChromeOptions();
			options.addArguments("--disable-notifications");
		}
		@Given("User mouse hovers on  Shop by Category")
		public void user_mouse_hovers_on_Shop_by_Category() {
			action =new Actions(driver);
			action.moveToElement(driver.findElementByXPath("//a[@class='dropdown-toggle meganav-shop']")).build().perform();

		}

		@Given("User goes to FOODGRAINS, OIL & MASALA and RICE & RICE PRODUCTS")
		public void user_goes_to_FOODGRAINS_OIL_MASALA_and_RICE_RICE_PRODUCTS() throws InterruptedException {
			action.moveToElement(driver.findElementByXPath("(//a[text()='Foodgrains, Oil & Masala'])[2]")).build().perform();
			Thread.sleep(3000);
			action.moveToElement(driver.findElementByLinkText("Rice & Rice Products")).click().build().perform();
		}
		@Given("User clicks on BOILED & STEAM RICE")
		public void user_clicks_on_BOILED_STEAM_RICE() {
		    action.moveToElement(driver.findElementByXPath("//span[text()='Boiled & Steam Rice']")).click().build().perform();
		}
		@Given("User gets the URL of the page and check it with site navigation link HOME > FOODGRAINS, OIL & MASALA> RICE & RICE PRODUCTS> BOILED & STEAM RICE")
		public void user_gets_the_URL_of_the_page_and_check_it_with_site_navigation_link_HOME_FOODGRAINS_OIL_MASALA_RICE_RICE_PRODUCTS_BOILED_STEAM_RICE() throws InterruptedException {
			String currentUrl = driver.getCurrentUrl();

			System.out.println(currentUrl);
			if (currentUrl.contains("boiled-steam-rice") ){
				System.out.println("url is correct");
			}
			else
				System.err.println("url is wrong");

			Thread.sleep(3000);
		}

		@Given("User chooses the Brand as bb Royal")
		public void user_chooses_the_Brand_as_bb_Royal() {
			driver.findElementByXPath("//span[text()='bb Royal']").click();
		}
		@Given("User goes to Ponni Boiled Rice and select {int}kg bag from Dropdown")
		public void user_goes_to_Ponni_Boiled_Rice_and_select_kg_bag_from_Dropdown(Integer int1) {
			//7) Go to Ponni Boiled Rice and select 10kg bag from Dropdown
			WebElement  select10kg = driver.findElementByXPath("(//button[@data-toggle='dropdown'])[2]");
			Select dropdown =new Select(select10kg);
			dropdown.selectByVisibleText("10kg");
		}

		@Given("User clicks Add button")
		public void user_clicks_Add_button() {
			//8) Click Add button
			driver.findElementByXPath("//button[@qa='add']").click();

		}

		@Given("User goes to search box and type Dal")
		public void user_goes_to_search_box_and_type_Dal() {
			//9) Go to search box and type Dal
			driver.findElementById("input").sendKeys("dal",Keys.ENTER);
		}

		@Given("User adds Toor\\/Arhar Dal {int}kg and set Qty {int} from the list")
		public void user_adds_Toor_Arhar_Dal_kg_and_set_Qty_from_the_list(Integer int1, Integer int2) throws InterruptedException {
			driver.findElementByXPath("(//a[contains(text(),'Thuvaram Paruppu')])[1]/following::span[2]").click();
			driver.findElementByXPath("(//a[contains(text(),'Thuvaram Paruppu')])[1]/following::span[2]/following::span[text()='2 kg'][1]").click();
			driver.findElementByXPath("(//a[contains(text(),'Thuvaram Paruppu')])[1]/following::input[@type='text'][1]").clear(); 
			driver.findElementByXPath("(//a[contains(text(),'Thuvaram Paruppu')])[1]/following::input[@type='text'][1]").sendKeys("2"); 
			driver.findElementByXPath("((//a[contains(text(),'Thuvaram Paruppu')])[1]/following::span[@class='discnt-price']//span/following::button)[1]").click();
			Thread.sleep(5000);
		}

		@Given("User clicks Address")
		public void user_clicks_Address() throws InterruptedException {
			//12) Select CHennai as City, Alandur-600016,Chennai as Area  and click Continue
			driver.findElementByXPath("(//span[text()='Select your city']/parent::span)[1]").click(); 
			driver.findElementByXPath("//input[@placeholder='Select your city']").sendKeys("Chennai");
			driver.findElementByXPath("//a[@class='ui-select-choices-row-inner']//span[text()='Chennai']").click(); 
			driver.findElementByXPath("//input[@qa='areaInput']").sendKeys("Alandur"); 
			Thread.sleep(2000);
			driver.findElementByXPath("(//strong[text()='Alandur']/parent::a[text()='-600016,Chennai'])[5]").click();
			driver.findElementByName("continue").click();
			
		}

		@Given("User selects Chennai as City, Alandur{int},Chennai as Area  and click Continue")
		public void user_selects_Chennai_as_City_Alandur_Chennai_as_Area_and_click_Continue(Integer int1) throws InterruptedException {
			driver.findElementByXPath("(//span[text()='Select your city']/parent::span)[1]").click(); 
			driver.findElementByXPath("//input[@placeholder='Select your city']").sendKeys("Chennai");
			driver.findElementByXPath("//a[@class='ui-select-choices-row-inner']//span[text()='Chennai']").click(); 
			driver.findElementByXPath("//input[@qa='areaInput']").sendKeys("Alandur"); 
			Thread.sleep(2000);
			driver.findElementByXPath("(//strong[text()='Alandur']/parent::a[text()='-600016,Chennai'])[5]").click();
			driver.findElementByName("continue").click();
			
		}

		@Given("User mouse hovers on My Basket take a screen shot")
		public void user_mouse_hovers_on_My_Basket_take_a_screen_shot() throws InterruptedException, IOException {  
			
			WebElement Basket = driver.findElementByXPath("//ul[@ng-show='vm.basketDrop']");
			File src = driver.getScreenshotAs(OutputType.FILE); 
			File dest = new File("./screens/BigBasket_MyBasket.png"); 
			FileUtils.copyFile(src, dest);
			Thread.sleep(2000);
		}

		@When("clicks View Basket and Checkout")
		public void clicks_View_Basket_and_Checkout() throws InterruptedException {
			//14) Click View Basket and Checkout
			action.moveToElement(driver.findElementByXPath("//a[@qa='myBasket']")).build().perform();
			action.moveToElement(driver.findElementByXPath("//button[text()='View Basket & Checkout']")).build().perform();
			action.click(driver.findElementByXPath("//button[text()='View Basket & Checkout']")).build().perform();
			Thread.sleep(3000);

		}

		@Then("clicks the close button and close the browser")
		public void clicks_the_close_button_and_close_the_browser() {
			//15) Click the close button and close the browser
			driver.quit();
		}}

