package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MicrosoftSSOPage {
	private WebDriver driver;

	// Các Locator cho các phần tử của trang Microsoft SSO
	private By emailField = By.id("i0116"); // ID của trường email trên Microsoft SSO
	private By nextButton = By.id("idSIButton9"); // ID của nút "Next"
	private By passwordField = By.id("i0118"); // ID của trường mật khẩu
	private By signInButton = By.id("idSIButton9"); // ID của nút "Sign in"
	private By staySignedInButton = By.id("idSIButton9"); // ID của nút "Yes" ở màn hình "Stay signed in"

	// Hàm khởi tạo
	public MicrosoftSSOPage(WebDriver driver) {
		this.driver = driver;
	}

	// Phương thức nhập email
	public void enterEmail(String email) {
		WebElement emailInput = driver.findElement(emailField);
		emailInput.sendKeys(email);
	}

	// Phương thức nhấn nút "Next"
	public void clickNext() {
		WebElement nextBtn = driver.findElement(nextButton);
		nextBtn.click();
	}

	// Phương thức nhập mật khẩu
	public void enterPassword(String password) {
		WebElement passwordInput = driver.findElement(passwordField);
		passwordInput.sendKeys(password);
	}

	// Phương thức nhấn nút "Sign in"
	public void clickSignIn() {
		WebElement signInBtn = driver.findElement(signInButton);
		signInBtn.click();
	}

	// Phương thức nhấn nút "Yes" ở màn hình "Stay signed in"
	public void clickStaySignedIn() {
		WebElement staySignedInBtn = driver.findElement(staySignedInButton);
		staySignedInBtn.click();
	}
}
