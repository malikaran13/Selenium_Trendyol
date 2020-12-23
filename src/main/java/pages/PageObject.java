package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PageObject {

    protected static WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
    }

    public void chrome(){
        System.setProperty("webdriver.chrome.driver", "src/main/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.setProperty("webdriver.log.file", "seleniumLogFile.txt");
    }

    public void firefox() {
        System.setProperty("webdriver.gecko.driver", "src/main/driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.setProperty("webdriver.log.file", "/seleniumLogFile.txt");
    }

    public void printLog(String logText, int status) throws IOException {
        FileWriter fw;
        fw = new FileWriter("report.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(logText);
        bw.newLine();
        bw.close();
    }

    public void closePage(){
        driver.quit();
    }

    public void waitForSeconds(int millisecond) throws InterruptedException {
        Thread.sleep(millisecond);
    }

    public List<String> readDataFromFile(String filePath) throws Exception
    {
        ArrayList<String> userData = new ArrayList<String>();
        // pass the path to the file as a parameter
        File file =
                new File(filePath);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            userData.add(sc.nextLine());
            //System.out.println(sc.nextLine());

        return userData;
    }

    public String setMail() throws Exception {
        return readDataFromFile("src/main/resources/UserData.txt").get(0);
    }

    public String setPassword() throws Exception{
        return readDataFromFile("src/main/resources/UserData.txt").get(1);
    }

}
