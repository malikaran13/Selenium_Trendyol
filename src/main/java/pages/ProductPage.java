package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends PageObject {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToBasket(){
        driver.findElement(By.xpath("(//*[@class=\"add-to-bs-tx\"])[1]")).click();
    }

}
