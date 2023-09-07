package org.example;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver   = new ChromeDriver(chromeOptions);
        Dimension website = new Dimension(768, 1024);
        driver.manage().window().setSize(website);
        driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1s");
        // driver.navigate().to("https://ksrtc.in/oprs-web/guest/home.do?h=1s");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //to navgate
        driver.findElement(By.xpath("/html/body/main/section/div/div/div[1]/div/div/div/a[2]/span[1]")).click();

        //select city
        driver.findElement(By.xpath("//*[@id='routeSlider']/div/div[2]/div/div/ul/li[1]/a")).click();
        //  driver.findElement(By.id("txtJourneyDate")).click();
        Thread.sleep(2500);
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[7]/a")).click();
//search bus
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block btn-booking']")).click();
        //to go seats
        driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[1]/div[1]/div[3]/div/input[4]")).click();
        // driver.findElement(By.name("SrvcSelectBtnForward")).click();
        //SrvcSelectBtnForward


//seat status
        driver.findElement(By.id("Forward104")).click();

        //*[@id="Forward-1467469338690"]

        //boarding point

        driver.findElement(By.xpath("//*[@class='p-2 Forward-boarding active1']")).click();
        //dropping point
        driver.findElement(By.xpath("//*[@class='p-2 Forward-droping active1']")).click();
        //mobileNo

        driver.findElement(By.id("mobileNo")).sendKeys("6789125987");
        //email
        driver.findElement(By.id("email")).sendKeys("abdosaber@gmail.com");

//personal
        //  driver.findElement(By.linkText(" Passenger Details ")).click();


        driver.findElement(By.xpath("//input[@name='passengerName']")).sendKeys("Abdelrahman");
        //dropdown

        // name="genderCodeId"
        WebElement element =driver.findElement(By.name("genderCodeId"));
        // element.click();
        Select selected =new Select(element);
        selected.selectByVisibleText("MALE");

        //age no
        driver.findElement(By.name("passengerAge")).sendKeys("20");


        //on con
        WebElement elements =driver.findElement(By.id("concessionIdsForward0"));
        Select selecte =new Select(elements);
        selecte.selectByVisibleText("GENERAL PUBLIC");


//nationality

        WebElement nationality =driver.findElement(By.name("nationality"));
        Select national =new Select(nationality);
        national.selectByValue("IN");

        //item

      boolean cv=  driver.findElement(By.name("passportNo")).isDisplayed();
System.out.println(cv);




    }}




