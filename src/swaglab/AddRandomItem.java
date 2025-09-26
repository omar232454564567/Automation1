package swaglab;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddRandomItem {

	WebDriver driver = new EdgeDriver();
	
	String URl = "https://www.saucedemo.com/";
	@BeforeTest
	public void mysetup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get(URl);

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
	//	WebElement Add = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));

		//Add.click();

	}

	@Test(priority = 2)
	public void AddRandItem()
	{
		Random rand = new Random();
		;
		int randitem = rand.nextInt(6); 
		;
	    System.out.print(randitem);
	   List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
	   List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
	   AddtoCartButtons.get(randitem).click();
	   System.out.print(ItemsNames.get(randitem).getText()+"has been added succesfully and his index is " + randitem + "/n");
	}
	
}
