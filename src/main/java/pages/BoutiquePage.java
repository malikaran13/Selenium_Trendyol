package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class BoutiquePage extends PageObject {

    public BoutiquePage(WebDriver driver) {
        super(driver);
    }

    public void openBrand(){
        driver.findElement(By.xpath("(//*[@class=\"image-container\"])[1]")).click();
    }

    public void openProduct(){
        driver.findElement(By.xpath("(//*[@class=\"image-container\"])[1]")).click();
    }

}
