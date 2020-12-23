package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage extends PageObject{

    public static String loginURL = "https://www.trendyol.com/login";
    public String mail = super.setMail();
    public String password = super.setPassword();

    public LoginPage(WebDriver driver) throws Exception {
        super(driver);
    }

    public void login() throws IOException {
        driver.get(loginURL);
        super.printLog("Login Page loaded",1);
        driver.findElement(By.id("login-email")).sendKeys(mail);
        driver.findElement(By.id("login-password-input")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

    }


}
