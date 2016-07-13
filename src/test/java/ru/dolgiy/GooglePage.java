package ru.dolgiy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anton on 13.07.2016.
 */
public class GooglePage {
    WebDriver driver=null;


    public void setUp() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(FirefoxDriver.BINARY, new
                File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe").getAbsolutePath());
        try {
            driver = new RemoteWebDriver(new URL("http://10.205.73.11:5555/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("ERROR!!" + e.toString());
        }
    }

    public void close(){
        driver.close();}

    public void open_url(String s){
        driver.get(s);}

    public void wait_for_smthng(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void search_input(String daString) {
        driver.findElement(By.id("lst-ib")).sendKeys(daString);
    }

    public void press_search (){
        driver.findElement(By.xpath(".//*[@id='sblsbb']/button")).click();
    }

    public WebElement get_snippet(String n){
        WebElement snippet = driver.findElements(By.xpath(".//*[@id='rso']/*/*/div/h3/a")).get(Integer.parseInt(n) - 1);
        return snippet;
    }
}


