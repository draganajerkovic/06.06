import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppointmenTest {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private SummaryPage summaryPage;
    private AppointmentPage appointmentPage;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\Desktop\\IT bootcamp\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driverWait=new WebDriverWait(driver, Duration.ofSeconds(15));
        loginPage=new LoginPage(driver, driverWait);
        summaryPage=new SummaryPage(driver,driverWait);
        appointmentPage=new AppointmentPage(driver, driverWait);
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void loginTest(){
        loginPage.chooseLogin();
        loginPage.usernamePassword("John Doe","ThisIsNotAPassword");
        Assert.assertEquals(loginPage.assertText(), "Make Appointment");
    }

    @Test(priority = 2)
    public void appointmentPageTest(){
        appointmentPage.chooseFascility();
        appointmentPage.chooseHospitalReadmission();
        appointmentPage.chooseRadioButton();
        appointmentPage.chooseDate();
        appointmentPage.writeComment();
        appointmentPage.clickAppointment();
        Assert.assertTrue(appointmentPage.isFormPresented());
    }

    @Test(priority = 3)
    public void summaryTest(){
        Assert.assertEquals(summaryPage.textFascilities(),"Tokyo CURA Healthcare Center");
        Assert.assertEquals(summaryPage.textApplyHospital(),"Yes");
        Assert.assertEquals(summaryPage.textRadioButton(),"Medicare");
        Assert.assertEquals(summaryPage.textVisitDate(),"21/09/2020");
        Assert.assertEquals(summaryPage.textTextComment(),"urgent");
    }
}
