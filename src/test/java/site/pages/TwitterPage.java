package site.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import utils.ClosePageException;

import java.util.ArrayList;


public class TwitterPage {

    private String oldTab;
    private WebDriver driver;

    public void setOldTab(String oldTab) {
        this.oldTab = oldTab;
    }

    public TwitterPage(WebDriver driver){
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        this.driver = driver;
    }

    @Step
    public void switchToPreviousTab(){
        driver.switchTo().window(oldTab);
    }

    @Step
    public void closeTwitter() throws ClosePageException {
        if (driver.getCurrentUrl().contains("https://twitter.com")){
            driver.close();
        }
        else{
            throw new ClosePageException("You try to close another page");
        }
    }

    @Step
    public String getURL() throws ClosePageException {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        return driver.getCurrentUrl();
    }
}
