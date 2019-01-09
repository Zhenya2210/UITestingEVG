package site.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//div[@class = 'wg-footer__social-block']")
public class SocialBlock extends HtmlElement {

    @FindBy(xpath = "//*[name()= 'svg' and child::*[name() = 'use' and contains(@*, 'twitter')]]")
    private Button twitter;

    public void clickTwitter(){
        twitter.click();
    }




}
