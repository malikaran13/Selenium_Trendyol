package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class HomePage extends PageObject {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyPage() throws IOException {
        boolean flag = false;
        WebElement logo = driver.findElement(By.id("logo"));
        Boolean logoPresent = logo.isDisplayed();
        if (logoPresent == true) {
            flag = true;
            System.out.println("Login successful");
            super.printLog("Page verified", 0);
        }
        return flag;
    }

    public void openBoutique(){
        driver.findElement(By.xpath("(//*[@class=\"category-header\"])[1]")).click();
    }

    public void listOfImagesFailed() {

        try {
            WebElement boutiquesTable = driver.findElement(By.xpath("//*[@id=\"container\"]"));
            List<WebElement> rowNumber = boutiquesTable.findElements((By.xpath("//*[img[contains(@class, 'error')]]")));
            if (rowNumber == null) {
                System.out.println("Loaded all boutiques successfully");
                printLog("Loaded all boutiques successfully", 0);
            } else {
                String getAttributeTitle;
                String err = "";
                for (WebElement rowBoutique : rowNumber) {
                    getAttributeTitle = rowBoutique.getAttribute("title");
                    err = ("Boutique loading error - title : " + getAttributeTitle);
                    System.out.println(err);
                    printLog(err, 0);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public void orderProduct(){
        driver.findElement(By.xpath("//*[@class=\"component-item\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"add-to-basket-button\"][1]")).click();
        driver.findElement(By.xpath("//*[@class=\"go-to-basket-button\"]")).click();
    }

}
