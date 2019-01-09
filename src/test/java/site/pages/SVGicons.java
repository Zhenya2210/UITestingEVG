package site.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClosePageException;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class SVGicons {

    private WebDriver driver;

    public SVGicons(WebDriver driver){
        this.driver = driver;
    }

    @Step
    public void closeSVGicons() throws ClosePageException {
        if (driver.getCurrentUrl().contains("icons.symbol.svg")){
            driver.close();
        }
        else {
            throw new ClosePageException("You try to close another page.");
        }
    }

    @Step
    public String getPathSVGicon(String icon) throws AWTException, ClosePageException{
        int quantityTab = driver.getWindowHandles().size();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        while (driver.getWindowHandles().size() != quantityTab + 1){}
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        driver.get("https://www.wrike.com/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg");
        String pathResult = driver.findElement(By.xpath("//*[@id = '" + icon + "']//*[name() = 'path']")).getAttribute("d");
        closeSVGicons();
        return pathResult;
    }

}
