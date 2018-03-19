	package pack_eImport;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;

	public class A_Request_Creation 
	{
		public WebDriver driver;
		public String baseURL = "https://bolla.su:Vertex37@pgitrade.pg.com/MercuryDev/Home.aspx";
					
		@Test(priority = 1)
		public void verify_Login() 
		{
			System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(baseURL);
			driver.navigate().refresh();
		}
		
		@Test(priority = 2)
		public void Requestor_Info() throws InterruptedException
		{
			// Implicitly wait for 10 seconds
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			// Upon login click on eImport tab at the top menu in the home page
			driver.findElement(By.xpath("//input[@id='MercuryHeader1_imgeImport']")).click();
			// Select a region - Asia
			driver.findElement(By.xpath("//a[@id='AAsia']")).click();
			// Select an Importing country - Vietnam
			driver.findElement(By.xpath("//input[@id='cmbCountry_I']")).click();
			driver.findElement(By.xpath("//td[text() = 'Vietnam']")).click();
			// Click on Submit button
			driver.findElement(By.xpath("//span[text() = 'Submit']")).click();
			// Click on Create request from the left menu
			driver.findElement(By.xpath("//a[@id='ctl00_UserMenu_aGPR']")).click();
			// User will be navigated to Requestor info and General info page.
			// Enter General info - Select Lane type
			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_cmbLaneType_I']")).click();
			driver.findElement(By.xpath("//td[text() = 'One-Time (BCP)']")).click();
			// Select Incoterm-log
			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_cmbIncotermLeg_I']")).click();
			driver.findElement(By.xpath("//td[@id='ctl00_MainContent_cmbIncotermLeg_DDD_L_LBI1T0' and text() = 'CFR - Cost & Freight']")).click();
			Thread.sleep(5000);
			// Enter name of place
			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_txtNameofPlace']")).sendKeys("Test Place");
			// Select Product type
			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_cmbProductType_I']")).click();
			driver.findElement(By.xpath("//td[@id='ctl00_MainContent_cmbProductType_DDD_L_LBI1T0']")).click();
			// Select Origin country
			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_cmbOriginCountry_I']")).click();
			driver.findElement(By.xpath("//td[text() = 'Hong Kong']")).click();
			// Click on Submit button
			driver.findElement(By.xpath("//span[text() = 'Submit']")).click();
			// Handle the "Request saved successfully alert"
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}

		@Test(priority = 3)
		public void Involved_Parties() throws InterruptedException
		{
			// Implicitly wait for 10 seconds
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			// Click on Involved parties tab in the left menu
			driver.findElement(By.xpath("//a[@id='aInvolvedParties']")).click();
			// Click on Seller type dropdown and select Contract manufacturer from Seller layer
			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_pnlShipperCallback_cmbSellerType_I']")).click();
			driver.findElement(By.xpath("//td[@id='ctl00_MainContent_pnlShipperCallback_cmbSellerType_DDD_L_LBI1T0' and text() ='Contract Manufacturer']")).click();
			Thread.sleep(5000);
			// Click on Seller Name/Legal Entity and enter data
			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_pnlShipperCallback_txtSellerName_I']")).clear();
			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_pnlShipperCallback_txtSellerName_I']")).sendKeys("Vertex Test Destination");
			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_pnlShipperCallback_txtSellerName_I']")).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			// Click on Same as Seller checkbox in the Supplier/shipper layer
			driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_pnlShipperCallback_chkSameasSeller_S_D']")).click();
			// Click on Sold to type dropdown and select Customer from the Sold to party layer
			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_pnlShipperCallback_cmbSoldToType_I']")).click();
			driver.findElement(By.xpath("//td[@id='ctl00_MainContent_pnlShipperCallback_cmbSoldToType_DDD_L_LBI1T0' and text() = 'Customer']")).click();
			Thread.sleep(5000);
			// Click Sold to name/Buyer LE dropdown and select 234
			driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_pnlShipperCallback_txtSoldToNameTxt_I']")).clear();
			driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_pnlShipperCallback_txtSoldToNameTxt_I']")).sendKeys("234");
			driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_pnlShipperCallback_txtSoldToNameTxt_I']")).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			// Select "Same as sold to party" checkbox in the Ship to party layer
			driver.findElement(By.xpath("//span[@id='ctl00_MainContent_pnlShipperCallback_chkSameAsSoldToParty_S_D']")).click();
			// Click on Submit button
			driver.findElement(By.xpath("//span[@class = 'dx-vam' and text() = 'Submit']")).click();
			// Handle the alert
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
		
		@Test(priority = 4)
		public void Description_of_Goods()
		{
			// Implicitly wait for 10 seconds
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Click on Description of goods tab from the left menu
			driver.findElement(By.xpath("//a[@id='aDescOfGoods']")).click();
			// Enter P&G Item Number
			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_txtItemNumber']")).sendKeys("99807057");
			// Enter Item Description
			driver.findElement(By.xpath("//textarea[@id='ctl00_MainContent_memGoodDesc']")).sendKeys("Test Description");
			// Click on  Manufacturing Plant Country dropdown and select country Vietnam
			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_cmbCountryofOriginPOP_I']")).click();
			driver.findElement(By.xpath("//td[@id='ctl00_MainContent_cmbCountryofOriginPOP_DDD_L_LBI241T0']")).click();
			// Enter Manufacturing plant name
			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_txtManufacturingPlantName']")).sendKeys("Test Plant");
			// Enter Product Description in the Art Work
			driver.findElement(By.xpath("//textarea[@id='ctl00_MainContent_memProductDescription']")).sendKeys("Test Description");
			// Enter What is this material made of?
			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_txtMadeOf']")).sendKeys("Test Material");
			// Enter What is the primary function or purpose of this item?
			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_txtPrimaryFunction']")).sendKeys("Test");
			// Click on Submit item button
			driver.findElement(By.xpath("//span[@class = 'dx-vam' and text() = 'Submit Item']")).click();
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			// Click on Submit
			driver.findElement(By.xpath("//span[@class = 'dx-vam' and text() = 'Submit']")).click();
			Alert alert1 = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert1.accept();
			System.out.println("Request has been created successfully by the Admin and the OD has to approve the same in the next steps");
			driver.close();
		}
	}

