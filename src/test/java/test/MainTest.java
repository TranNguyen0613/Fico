package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MicrosoftSSOPage;
import java.util.concurrent.TimeUnit;

public class MainTest {
	private WebDriver driver;
	private LoginPage loginPage;
	private MicrosoftSSOPage microsoftSSOPage;
	private DashboardPage dashboardPage;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\myPCCCCC\\eclipse-workspace\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Điều hướng đến trang đăng nhập
		driver.get("https://fico-salex-admin-panel-dev.estuary.solutions/login");

		// Khởi tạo các trang
		loginPage = new LoginPage(driver);
		microsoftSSOPage = new MicrosoftSSOPage(driver);
		dashboardPage = new DashboardPage(driver);
	}

	@Test(priority = 1)
	public void testLoginWithMicrosoftSSO() throws InterruptedException {
		// Thực hiện đăng nhập Microsoft SSO
		loginPage.clickMicrosoftSSO();

		// Chuyển sang cửa sổ SSO
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		microsoftSSOPage.enterEmail("quetran.nguyen@estuary.solutions");
		Thread.sleep(1000);
		microsoftSSOPage.clickNext();
		microsoftSSOPage.enterPassword("Okitasouji%1802");
		Thread.sleep(1000);
		microsoftSSOPage.clickSignIn();
		Thread.sleep(1000);
		microsoftSSOPage.clickStaySignedIn();

		// Trở lại trang chính
		driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
	}

	@Test(priority = 2, dependsOnMethods = "testLoginWithMicrosoftSSO")
	public void testDashboardTitle() {
		// Kiểm tra tiêu đề bảng điều khiển
		String title = dashboardPage.getDashboardTitle();
		Assert.assertEquals(title, "Dashboard", "Dashboard title is incorrect.");
	}

	@Test(priority = 3, dependsOnMethods = "testLoginWithMicrosoftSSO")
	public void testSearchProject() {
		// Tìm kiếm một dự án
		dashboardPage.searchProject("Example Project");
		// Thực hiện các kiểm tra liên quan đến kết quả tìm kiếm nếu cần
	}

	@Test(priority = 4, dependsOnMethods = "testLoginWithMicrosoftSSO")
	public void testClickSpecificLink() {
		// Nhấn vào một liên kết hoặc nút cụ thể
		dashboardPage.clickSpecificLink();
		// Thực hiện các kiểm tra sau khi nhấn nút nếu cần
	}

	@Test(priority = 5, dependsOnMethods = "testLoginWithMicrosoftSSO")
	public void testNavigateToSalesManagement() {
		// Điều hướng đến 'System > Sales'
		dashboardPage.navigateToSales();

		// Xác minh rằng trang Sales Management đã được hiển thị
		Assert.assertTrue(dashboardPage.isSalesManagementPageDisplayed(), "Sales Management page is not displayed.");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
