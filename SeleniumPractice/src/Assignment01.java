import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment01 {

	WebDriver driver;
	String url="https://accounts.google.com/signup";

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver","F:\\selenium\\Selenium New Jar Files\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//Thread.sleep(3000);
	}

	@After
	public void tearDown() throws Exception {
		//driver.close();
	}

	@Test
	public void test() {

		WebElement firstname=driver.findElement(By.id("firstName"));
		firstname.sendKeys("FirstName1");
		String fname=firstname.getAttribute("value");
		System.out.println("First Name : "+fname);						// Printing the First name Written

		WebElement lastname=driver.findElement(By.id("lastName"));
		lastname.sendKeys("LastName1");
		String lname=lastname.getAttribute("value");
		System.out.println("Last Name : "+lname);						// Printing the Last name Written

		driver.findElement(By.id("username")).sendKeys("P@ssword");						

		WebElement password=driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input"));
		password.sendKeys("abcdef!@2345");
		String confirmpassword=password.getAttribute("value");

		driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).sendKeys(confirmpassword);

		driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/span/span")).click();

		if(driver.getCurrentUrl()=="https://accounts.google.com/signup" || driver.getCurrentUrl().contains("SignUp"))
		{
			if(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/form/div[2]/div/div[1]/div[2]/div[3]")).isDisplayed()) 
			{
				String sug1=driver.findElement(By.xpath("//*[@id=\"usernameList\"]/li[1]/button")).getText();
				String sug2=driver.findElement(By.xpath("//*[@id=\"usernameList\"]/li[2]/button")).getText();
				String sug3=driver.findElement(By.xpath("//*[@id=\"usernameList\"]/li[3]/button")).getText();
				driver.findElement(By.id("username")).clear();
				driver.findElement(By.id("username")).sendKeys(sug1);
				driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/span/span")).click();

			}
			else
			{
				driver.findElement(By.id("username")).clear();
				driver.findElement(By.id("username")).sendKeys("LearnAtDemo");
				driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/span/span")).click();
			}


		}

		String txt=driver.findElement(By.id("headingText")).getText();
		if(txt.equalsIgnoreCase("Verifying your phone number")) {
			System.out.println("Successfull");
		}

	}

}
