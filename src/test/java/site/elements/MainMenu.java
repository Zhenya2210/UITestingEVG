package site.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Main menu")
@FindBy(xpath = "//div[@class = 'wg-header__sticky-mainmenu']")
public class MainMenu extends HtmlElement{

    @Name("Button Get started for free")
    @FindBy(xpath = "//div[@class = 'wg-header__sticky-mainmenu']//button[text()='Get started ']")
    private Button GetStarted;

    public void getStartedClick(){
        GetStarted.click();
    }




}
