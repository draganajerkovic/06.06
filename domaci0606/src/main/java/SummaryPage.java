import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SummaryPage extends  BasePage{

    private By fascilitiesSummary=By.xpath("//*[@id=\"facility\"]");
    private By applyHospitalReadmisionSummary=By.xpath("//*[@id=\"hospital_readmission\"]");
    private By radioButtonSummary=By.id("program");
    private By visitDateSummary=By.id("visit_date");
    private By textCommentSummary=By.xpath("//*[@id=\"comment\"]");
    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getFascilitiesSummary() {
        return fascilitiesSummary;
    }

    public By getApplyHospitalReadmisionSummary() {
        return applyHospitalReadmisionSummary;
    }

    public By getRadioButtonSummary() {
        return radioButtonSummary;
    }

    public By getVisitDateSummary() {
        return visitDateSummary;
    }

    public By getTextCommentSummary() {
        return textCommentSummary;
    }

    public String textFascilities(){
        return getDriver().findElement(fascilitiesSummary).getText();
 }

    public String textApplyHospital(){
        return getDriver().findElement(applyHospitalReadmisionSummary).getText();
    }

    public String textRadioButton(){
        return getDriver().findElement(radioButtonSummary).getText();
    }

    public String textVisitDate(){
        return getDriver().findElement(visitDateSummary).getText();
    }

    public String textTextComment(){
        return getDriver().findElement(textCommentSummary).getText();
    }
}
