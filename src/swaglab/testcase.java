package swaglab;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testcase {
	WebDriver driver = new ChromeDriver();
	String MyWebsite = "https://www.saucedemo.com/";

	@BeforeTest
	public void mysetup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().window().maximize();
		driver.get(MyWebsite);

	}

	@Test(priority = 1)
	public void Login() {

		// elements
		String username = "standard_user";
		String password = "secret_sauce";
		WebElement NameInput = driver.findElement(By.id("user-name"));
		WebElement PasswordInput = driver.findElement(By.id("password"));
		WebElement Buttoun = driver.findElement(By.id("login-button"));

		// actions
		NameInput.sendKeys(username);
		PasswordInput.sendKeys(password);
		Buttoun.click();
		WebElement Add = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));

		Add.click();

	}

	@Test(priority = 2)
	public void Checkout() {

		driver.navigate().to("https://www.saucedemo.com/cart.html");

	}
}
