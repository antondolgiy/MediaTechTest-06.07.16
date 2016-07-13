package ru.dolgiy;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Anton on 13.07.2016.
 */
public class RemoteDriverSetuper {
    RemoteWebDriver driver=null;
    public RemoteWebDriver setUp() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(FirefoxDriver.BINARY, new
                File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe").getAbsolutePath());
        try {
            driver = new RemoteWebDriver(new URL("http://10.205.73.11:5555/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("ERROR!!" + e.toString());
        }
        return driver;
    }

}
