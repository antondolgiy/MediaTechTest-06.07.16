package ru.dolgiy;



import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
import static org.junit.Assert.assertEquals;


/**
 * Created by Anton on 06.07.2016.
 */
public class TestSteps {

        WebDriver driver=null;
        @Before
        public void setUp(){
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability(FirefoxDriver.BINARY,new
                    File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe").getAbsolutePath());
            try {
                driver =new RemoteWebDriver(new URL("http://10.205.73.11:5555/wd/hub"),capabilities);}
            catch (MalformedURLException e){System.out.println("ERROR!!"+e.toString());}

    }
        @After
        public void closeDawn() {
        driver.close();
    }

        @Given("^Open page by url \"([^\"]*)\" in browser$")
        public void open_page_by_url_in_browser (String arg1)throws Throwable {

        driver.get(arg1);
    }

        @Given("^Type to search input \"([^\"]*)\"$")
        public void type_to_search_input (String arg1)throws Throwable {
        driver.findElement(By.id("lst-ib")).sendKeys(arg1);

    }

        @When("^Press button search$")
        public void press_button_search ()throws Throwable {
        driver.findElement(By.xpath(".//*[@id='sblsbb']/button")).click();


    }

        @Then("^Header search snippet \"([^\"]*)\" text equals \"([^\"]*)\"$")
        public void header_search_snippet_text_equals (String arg1, String arg2)throws Throwable {
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement snippet = driver.findElements(By.xpath(".//*[@id='rso']/*/*/div/h3/a")).get(Integer.parseInt(arg1) - 1);

        assertEquals(arg2,snippet.getText());

    }


}
