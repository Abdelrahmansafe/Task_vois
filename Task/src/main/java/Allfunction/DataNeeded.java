package Allfunction;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class  DataNeeded {
    protected   WebDriver driver ;

public  void beforeTest(String url){
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
    driver = new ChromeDriver(chromeOptions);
    driver.manage().window().maximize();
    driver.get(url);
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

}

//run before testcase

    public void BeforeTest(String url) {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(chromeOptions);
        Dimension website = new Dimension(768, 1024);
        driver.manage().window().setSize(website);
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    //common code need it in ksrtcAwatar
    public void ElementNeed(){

        driver.findElement(By.xpath("/html/body/main/section/div/div/div[1]/div/div/div/a[2]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id='routeSlider']/div/div[2]/div/div/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[7]/a")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block btn-booking']")).click();
        driver.findElement(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div/div/div[2]/div[1]/div[1]/div[3]/div/input[4]")).click();


    }
    //common code need it in ksrtcAwatar
    public void ElementNecessary(String phone,String name,String email ,String age){

        driver.findElement(By.id("Forward48")).click();
        driver.findElement(By.xpath("//*[@class='p-2 Forward-boarding active1']")).click();
        driver.findElement(By.xpath("//*[@class='p-2 Forward-droping active1']")).click();
        driver.findElement(By.id("mobileNo")).sendKeys(phone);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='passengerName']")).sendKeys(name);
        ///////////////////////////////////////////////////////////
        WebElement element =driver.findElement(By.name("genderCodeId"));
        Select selected =new Select(element);
        selected.selectByVisibleText("MALE");
        //////////////////////////////////////////////
        driver.findElement(By.name("passengerAge")).sendKeys(age);
        /////////////////////////////////////////////////////
        WebElement concession =driver.findElement(By.id("concessionIdsForward0"));
        Select select_concession =new Select(concession);
        select_concession.selectByVisibleText("GENERAL PUBLIC");
        //////////////////////////////////////////////////////////




    }









    public void EndPoint() {


        driver.quit();


    }












}
