package site.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import site.elements.MainMenu;
import site.elements.PopUpStartFree;
import utils.ClosePageException;

public class StartPage {

    private MainMenu mainMenu = new MainMenu();
    private PopUpStartFree popUpStartFree = new PopUpStartFree();
    private WebDriver driver;

    public StartPage(WebDriver driver){
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        this.driver = driver;
    }

    @Step
    public void closeStart() throws ClosePageException {
        if (driver.getCurrentUrl().equals("https://www.wrike.com/")){
            driver.close();
        }
        else {
            throw new ClosePageException("You try to close another page.");
        }
    }

    @Step
    public void getStartedClick(){
        mainMenu.getStartedClick();
    }

    @Step
    public void enterEmail(String email){
        popUpStartFree.enterEmail(email);
    }
}
