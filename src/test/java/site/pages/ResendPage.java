package site.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import site.elements.QuestionForm;
import site.elements.SocialBlock;
import site.elements.ThankYouBlock;
import utils.BaseTest;
import utils.ClosePageException;
import utils.Helper;

public class ResendPage {

    private QuestionForm questionForm = new QuestionForm();
    private ThankYouBlock thankYouBlock = new ThankYouBlock();
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private SocialBlock socialBlock = new SocialBlock();

    public ResendPage(WebDriver driver, WebDriverWait webDriverWait){
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    @Step
    public void closeResend() throws ClosePageException {
        if (driver.getCurrentUrl().equals("https://www.wrike.com/resend/")){
            driver.close();
        }
        else {
            throw new ClosePageException("You try to close another page.");
        }
    }

    @Step
    public void answerTheFirstQuestion(){
        int numberOfQuestion = Helper.getRandomNumber(2);
        switch (numberOfQuestion){
            case 1:
                questionForm.click_answer_Very_interested();
                break;
            case 2:
                questionForm.click_answer_Just_looking();
                break;
        }
    }

    @Step
    public void answerTheSecondQuestion(){
        int numberOfQuestion = Helper.getRandomNumber(5);
        switch (numberOfQuestion){
            case 1:
                questionForm.click_answer_1_to_5();
                break;
            case 2:
                questionForm.click_answer_6_to_15();
                break;
            case 3:
                questionForm.click_answer_16_to_25();
                break;
            case 4:
                questionForm.click_answer_26_to_50();
                break;
            case 5:
                questionForm.click_answer_50_and_plus();
                break;
        }
    }

    @Step
    public void answerTheThirdQuestion(){
        int numberOfQuestion = Helper.getRandomNumber(3);
        switch (numberOfQuestion){
            case 1:
                questionForm.click_answer_Yes();
                break;
            case 2:
                questionForm.click_answer_No();
                break;
            case 3:
                questionForm.click_answer_Other_and_enter_text("Hello World!");
                break;
        }
    }

    @Step
    public void submitResults(){
        questionForm.click_Submit_results();
    }

    public String getURL(){
        webDriverWait.until(ExpectedConditions.visibilityOf(questionForm));
        return driver.getCurrentUrl();
    }

    @Step
    public String getMessageAfterSuccessfulSending(){
        return questionForm.getMessageAfterSuccessfulSending();
    }

    @Step
    public void resendEmail(){
        thankYouBlock.clickResendEmail();
    }

    public boolean isDisplayedResendEmail(){
        webDriverWait.until(ExpectedConditions.invisibilityOf(thankYouBlock.getResendEmail()));
        return thankYouBlock.isDisplayedResendEmail();
    }

    @Step
    public String getThankYouMessage(){
        return thankYouBlock.getMessage();
    }

    @Step
    public void clickTwitter(){
        String currentTab = driver.getWindowHandle();
        socialBlock.clickTwitter();
        BaseTest.twitterPage.setOldTab(currentTab);
    }



}
