package tests;

import org.junit.Test;
import utils.BaseTest;
import utils.ClosePageException;
import utils.Helper;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class WrikeTests extends BaseTest {

    private final String email = Helper.getRandomEmail();
    private final String expectedResendPageURL = "https://www.wrike.com/resend/";
    private final String expectedMessageAfterSuccessfulSending = "Thanks for helping us out!";
    private final String expectedThankYouText = "We’ve sent you an activation email\n" + "at " + email
            + " again. Please check your inbox and follow the link to complete your registration.";
    private final String expectedURLTwitter = "https://twitter.com/wrike";
    private final String expectedTwitterIconPath = "M14.2 3.2v.42A9.23 9.23 0 0 1-.01 11.39a6.66 6.66 0 0 0 .78 0 6.5 6.5 0 0 0 4-1.38 3.25 3.25 0 0 1-3-2.25 4.21 4.21 0 0 0 .61 0 3.42 3.42 0 0 0 .85-.11 3.24 3.24 0 0 1-2.6-3.18 3.27 3.27 0 0 0 1.47.41 " +
            "3.25 3.25 0 0 1-1-4.34 9.22 9.22 0 0 0 6.69 3.39 3.66 3.66 0 0 1-.08-.74A3.25 3.25 0 0 1 13.32.97a6.39 6.39 0 0 0 2.06-.78 3.23 3.23 0 0 1-1.43 1.79 6.5 6.5 0 0 0 1.87-.5A7 7 0 0 1 14.2 3.2z";

    @Test
    public void testScenario() throws AWTException, ClosePageException {
        startPage.getStartedClick();
        startPage.enterEmail(email);
        assertEquals(expectedResendPageURL, resendPage.getURL());
        resendPage.answerTheFirstQuestion();
        resendPage.answerTheSecondQuestion();
        resendPage.answerTheThirdQuestion();
        resendPage.submitResults();
        assertEquals(expectedMessageAfterSuccessfulSending, resendPage.getMessageAfterSuccessfulSending());
        resendPage.resendEmail();
        assertFalse(resendPage.isDisplayedResendEmail());
        assertEquals(expectedThankYouText, resendPage.getThankYouMessage());
        resendPage.clickTwitter();
        assertEquals(expectedURLTwitter, twitterPage.getURL());
        twitterPage.closeTwitter();
        twitterPage.switchToPreviousTab();
        assertEquals(expectedTwitterIconPath, svGicons.getPathSVGicon("twitter"));
    }


}
