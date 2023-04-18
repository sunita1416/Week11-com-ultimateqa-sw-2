package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;


    public void openBrowser(String baseUrl){ //url is a parameter
        driver = new ChromeDriver();
        //Launch the  URL
        driver.get(baseUrl);
        // Maximise Window
        driver.manage().window().maximize();
        // Implicit time out
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser(){
        driver.close();
    }
}

