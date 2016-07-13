package ru.dolgiy;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Anton on 13.07.2016.
 */
public class GooglePage {

    RemoteWebDriver driver= new RemoteDriverSetuper().setUp();

    public void open_url(String s){
        driver.get(s);}

    //ждать обновления страницы
    public void wait_for_smthng(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    //ввести текст в окно запроса
    public void search_input(String daString) {
        driver.findElement(By.id("lst-ib")).sendKeys(daString);
    }
    //нажать кнопку "поиск"
    public void press_search (){
        driver.findElement(By.xpath(".//*[@id='sblsbb']/button")).click();
    }

    // найти n-ый блок(сниппет) в списке результатов поиска
    public WebElement get_snippet(String n){
        WebElement snippet = driver.findElements(By.xpath(".//*[@id='rso']/*/*/div/h3/a")).get(Integer.parseInt(n) - 1);
        return snippet;
    }

    public void close(){
        driver.close();
    }
}


