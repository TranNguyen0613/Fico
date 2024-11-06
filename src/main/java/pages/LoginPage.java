package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;

	// Locator cho nút SSO Microsoft 365
	private By microsoftSSOButton = By.xpath("(//*[name()='path'][@fill='#ffffff'])[1]");

	// Hàm khởi tạo
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Phương thức nhấn vào nút đăng nhập Microsoft SSO
	public void clickMicrosoftSSO() {
		WebElement loginButton = driver.findElement(microsoftSSOButton);
		loginButton.click();
	}
}
