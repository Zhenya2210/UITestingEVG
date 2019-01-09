package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.pages.ResendPage;
import site.pages.SVGicons;
import site.pages.StartPage;
import site.pages.TwitterPage;


public class BaseTest {

    private static WebDriver driver;
    private static WebDriverWait webDriverWait;
    private static JavascriptExecutor executor;
    protected static StartPage startPage;
    protected static ResendPage resendPage;
    public static TwitterPage twitterPage;
    protected static SVGicons svGicons;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        executor = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://www.wrike.com");
        startPage = new StartPage(driver);
        resendPage = new ResendPage(driver, webDriverWait);
        twitterPage = new TwitterPage(driver);
        svGicons = new SVGicons(driver);


    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
