package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage {
	private WebDriver driver;

	// Các Locator cho các phần tử trên trang bảng điều khiển
	private By dashboardTitle = By.xpath("//h1[contains(text(),'Dashboard')]"); // Giả định tiêu đề bảng điều khiển có
																				// từ 'Dashboard'
	private By searchBox = By.id("search-box"); // Thay đổi ID của ô tìm kiếm nếu cần
	private By searchButton = By.id("search-button"); // Thay đổi ID của nút tìm kiếm nếu cần
	private By someLinkOrButton = By.id("specific-link"); // ID của một nút hoặc liên kết cụ thể trên trang
	private By systemMenu = By.id("system-menu"); // Thay đổi ID nếu cần
	private By salesSubMenu = By.id("sales-submenu"); // Thay đổi ID nếu cần
	// Locator cho tiêu đề của trang Sales Management
	private By salesManagementTitle = By.xpath("//h1[contains(text(),'Sales Management')]"); // Thay đổi XPath nếu cần

	// Hàm khởi tạo
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// Phương thức di chuột qua 'System' và nhấn vào 'Sales'
	public void navigateToSales() {
		Actions actions = new Actions(driver);
		WebElement systemMenuElement = driver.findElement(systemMenu);
		actions.moveToElement(systemMenuElement).perform(); // Di chuột qua menu 'System'

		WebElement salesMenuElement = driver.findElement(salesSubMenu);
		actions.moveToElement(salesMenuElement).click().perform(); // Nhấp vào submenu 'Sales'
	}

	// Phương thức để xác minh trang Sales Management
	public boolean isSalesManagementPageDisplayed() {
		WebElement titleElement = driver.findElement(salesManagementTitle);
		return titleElement.isDisplayed();
	}

	// Phương thức để kiểm tra tiêu đề bảng điều khiển
	public String getDashboardTitle() {
		WebElement titleElement = driver.findElement(dashboardTitle);
		return titleElement.getText();
	}

	// Phương thức tìm kiếm dự án hoặc nội dung cụ thể
	public void searchProject(String projectName) {
		WebElement searchInput = driver.findElement(searchBox);
		searchInput.clear();
		searchInput.sendKeys(projectName);

		WebElement searchBtn = driver.findElement(searchButton);
		searchBtn.click();
	}

	// Phương thức nhấn vào một liên kết hoặc nút cụ thể trên bảng điều khiển
	public void clickSpecificLink() {
		WebElement linkElement = driver.findElement(someLinkOrButton);
		linkElement.click();
	}

	// Phương thức kiểm tra nếu bảng điều khiển đã được tải đầy đủ
	public boolean isDashboardLoaded() {
		return driver.findElement(dashboardTitle).isDisplayed();
	}
}
