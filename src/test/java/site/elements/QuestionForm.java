package site.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;


@Name("Question form \"Help us provide you the best possible experience\"")
@FindBy(xpath = "//form[@class='survey-form']")
public class QuestionForm extends HtmlElement{

    @FindBy(xpath = "//button[text()='Very interested']")
    private Button answerVeryInterested;

    @FindBy(xpath = "//button[text()='Just looking']")
    private Button answezJustLooking;

    @FindBy(xpath = "//button[text()='1–5']")
    private Button answer_1_to_5;

    @FindBy(xpath = "//button[text()='6–15']")
    private Button answer_6_to_15;

    @FindBy(xpath = "//button[text()='16–25']")
    private Button answer_16_to_25;

    @FindBy(xpath = "//button[text()='26–50']")
    private Button answer_26_to_50;

    @FindBy(xpath = "//button[text()='50+']")
    private Button answer_50_and_plus;

    @FindBy(xpath = "//button[text()='Yes']")
    private Button answerYes;

    @FindBy(xpath = "//button[contains(text(), '   No')]")
    private Button answerNo;

    @FindBy(xpath = "//button[contains(text(), '    Other')]")
    private Button answerOther;

    @FindBy(xpath = "//button[contains(text(), '    Other')]//input")
    private TextInput answerOtherText;

    @FindBy(xpath = "//button[text() = 'Submit results']")
    private Button submitResults;

    @FindBy(xpath = "//div[@class='survey-success']/h3")
    private TextBlock messageAfterSuccessfulSending;

    public void click_answer_Very_interested(){
        answerVeryInterested.click();
    }

    public void click_answer_Just_looking(){
        answezJustLooking.click();
    }

    public void click_answer_1_to_5(){
        answer_1_to_5.click();
    }

    public void click_answer_6_to_15(){
        answer_6_to_15.click();
    }

    public void click_answer_16_to_25(){
        answer_16_to_25.click();
    }

    public void click_answer_26_to_50(){
        answer_26_to_50.click();
    }

    public void click_answer_50_and_plus(){
        answer_50_and_plus.click();
    }

    public void click_answer_Yes(){
        answerYes.click();
    }

    public void click_answer_No(){
        answerNo.click();
    }

    public void click_answer_Other_and_enter_text(String other){
        answerOther.click();
        answerOtherText.sendKeys(other);
    }

    public void click_Submit_results(){
        submitResults.click();
    }

    public String getMessageAfterSuccessfulSending(){
        while (!messageAfterSuccessfulSending.isDisplayed()){}
            return messageAfterSuccessfulSending.getText();
    }



}
