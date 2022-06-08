import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AppointmentPage extends BasePage{
    private By fascilities=By.xpath("//*[@id=\"combo_facility\"]");
    private By applyHospitalReadmision=By.xpath("//*[@id=\"appointment\"]/div/div/form/div[2]/div/label");
    private By radioButton=By.id("radio_program_medicare");
    private By visitDate=By.id("txt_visit_date");
    private By textComment=By.xpath("//*[@id=\"txt_comment\"]");
    private By bookAppointmentButton=By.id("btn-book-appointment");
    public AppointmentPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getFascilities() {
        return fascilities;
    }

    public By getApplyHospitalReadmision() {
        return applyHospitalReadmision;
    }

    public By getRadioButton() {
        return radioButton;
    }

    public By getVisitDate() {
        return visitDate;
    }

    public By getTextComment() {
        return textComment;
    }

    public By getBookAppointmentButton() {
        return bookAppointmentButton;
    }

    public void chooseFascility(){
        Select dropDownName=new Select(getDriver().findElement(fascilities));
        dropDownName.selectByVisibleText("Tokyo CURA Healthcare Center");
    }

    public void chooseHospitalReadmission(){
        getDriver().findElement(applyHospitalReadmision).click();
    }

    public void chooseRadioButton(){
        getDriver().findElement(radioButton).click();
    }

    public void chooseDate(){
        getDriver().findElement(visitDate).sendKeys("21/09/2020");
    }

    public void writeComment(){
        getDriver().findElement(textComment).sendKeys("urgent");
    }

    public void clickAppointment(){
        getDriver().findElement(bookAppointmentButton).click();
    }

    public boolean isFormPresented(){
        List<WebElement> appointments= getDriver().findElements(By.id("appointment"));
        if(appointments.size()>0){
            return false;
        } return true;
    }
}
