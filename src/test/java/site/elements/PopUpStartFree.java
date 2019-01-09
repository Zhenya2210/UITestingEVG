package site.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Pop-up window for the registration")
@FindBy(xpath = "//form[@data-hash='header_button_form']")
public class PopUpStartFree extends HtmlElement{

    @Name("Input email")
    @FindBy(xpath = "//input[@class='wg-input modal-form-trial__input']")
    private TextInput emailField;

    @Name("Create my Wrike account button")
    @FindBy(xpath = "//button[text()='Create my Wrike account']")
    private Button createMyWrikeAccount;

    public void enterEmail(String email){
        emailField.sendKeys(email);
        createMyWrikeAccount.click();
    }
}
