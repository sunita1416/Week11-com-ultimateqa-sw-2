package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        WebElement signINLink = driver.findElement(By.linkText("Sign In"));
        signINLink.click();

        // WebElement welcomeMsg = driver.findElement(By.xpath("//h1[text()='Welcome Back!']"));
        //Assert.assertEquals(welcomeMsg.getText(), "Welcome Back!");

    }

    @Test
    public void verifyTheErrorMessage() {
        // Find login link and click on login link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        // Find Email field and type the invalid email

        WebElement emailField = driver.findElement(By.id("user[email]"));

        emailField.sendKeys("prime1234@gmail.com");
        //Find the password field and type the password

        WebElement passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("prim123");

        WebElement button = driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']"));

        button.click();
        String expectedMessage = "Invalid email or password.";
        WebElement actualTextElement = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

        //WebElement errorMessage = driver.findElement(By.xpath(""));
        //Assert.assertEquals(errorMessage.getText(), "Invalid email or password.");
    }

    @After
    public void tearDown() {
       closeBrowser();

    }
}
