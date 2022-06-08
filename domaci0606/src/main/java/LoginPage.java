import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends  BasePage{

//    private By menu=By.id("menu-toogle");
//    private By loginFromMenu=By.id("menu-toggle");
    private By makeanAppointment=By.id("btn-make-appointment");
    private By username=By.id("txt-username");
    private By password=By.id("txt-password");
    private By loginButton=By.id("btn-login");

    private By makeAppointmenText=By.xpath("//*[@id=\"appointment\"]/div/div/div/h2");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    //metoda za ulaz na login stranicu
    public void chooseLogin(){

//        getDriver().findElement(menu).click();
//        getDriver().findElement(loginFromMenu).click();

        getDriver().findElement(makeanAppointment).click();

    }

    //metoda za unos username and password
    public void usernamePassword(String username, String password){
        getDriver().findElement(this.username).sendKeys(username);
        getDriver().findElement(this.password).sendKeys(password);
        getDriver().findElement(loginButton).click();
    }

    public String assertText(){
        return getDriver().findElement(makeAppointmenText).getText();
    }
}
