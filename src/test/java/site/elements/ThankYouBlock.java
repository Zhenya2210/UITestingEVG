package site.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

@FindBy(xpath = "//div[@class = 'wg-cell wg-cell--order-1 wg-cell--md-5 wg-cell--md-5 wg-cell--md-offset-1 wg-cell--lg-4 wg-cell--lg-offset-1']")
public class ThankYouBlock extends HtmlElement {

    @FindBy(xpath = "//div[@class = 'wg-grid']//button[text() = 'Resend email']")
    private Button resendEmail;

    @FindBy(xpath = "//p[@class = 'h4 subtitle']")
    private TextBlock message;

    public Button getResendEmail() {
        return resendEmail;
    }

    public void clickResendEmail(){
        resendEmail.click();
    }

    public boolean isDisplayedResendEmail(){
        if (resendEmail.isDisplayed()){
            return true;
        }
        else {
            return false;
        }
    }

    public String getMessage(){
        return message.getText();
    }





}
