package KSRTCAWATAR;

import Allfunction.DataNeeded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class KsrtcAwatar extends DataNeeded {
  //  public WebDriver driver ;

    @BeforeMethod
    public void Before() {

        beforeTest("https://ksrtc.in/oprs-web/guest/home.do?h=1s");

    }
  

    @Test(priority = 1,dataProvider = "ForeignInfo",dataProviderClass = CustomerDataProvider.class)

    public void VaildSelectSeat(String phone,String name,String email ,String age ,String address,String data){
        ElementNeed();
        ElementNecessary(phone, name, email, age);
        //////////////////////////////////////////////////////////
        WebElement nationality =driver.findElement(By.name("nationality"));
        Select national =new Select(nationality);
        national.selectByValue("EG");
        ////////////////////////////////////////////
        driver.findElement(By.name("passportNo")).sendKeys(name);
        driver.findElement(By.name("foreignerAddress")).sendKeys(address);
        driver.findElement(By.name("dob")).sendKeys(data);
        driver.findElement(By.name("PgBtn")).click();
        Assert.assertTrue(true,"faild in create travel");

    }

// to check indin nationality
    @Test(priority = 2,dataProvider = "PublicInfo",dataProviderClass = CustomerDataProvider.class)
   public void nationalityTest(String phone,String name,String email ,String age){

        ElementNeed();
        ElementNecessary(phone, name, email, age);


        WebElement nationality =driver.findElement(By.name("nationality"));
        Select national =new Select(nationality);
        national.selectByValue("IN");

        //item

        boolean cv=  driver.findElement(By.name("passportNo")).isDisplayed();
        Assert.assertFalse(cv,"erorr in logic");



    }

  
// to check status seat
    @Test(priority = 3)
  
    public void SeatValidation(){
        ElementNeed();
        WebElement b= driver.findElement(By.id("Forward78"));
        String colors= b.getCssValue("background-color");
        String hex= Color.fromString(colors).asHex();
        Assert.assertEquals(hex,"#ffffff","please select another seat");

    }




//to check before bay
@Test(priority = 4)
    public void CalenderDayValidation(){
        driver.findElement(By.xpath("/html/body/main/section/div/div/div[1]/div/div/div/a[2]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id='routeSlider']/div/div[2]/div/div/ul/li[1]/a")).click();
        LocalDate currentDate = LocalDate.now();
        int dayOfMonth = currentDate.getDayOfMonth();
        WebElement ElementDayBefore= driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[2]/span"));
        int before= Integer.parseInt( ElementDayBefore.getText());
        if(dayOfMonth>before){
            Boolean check = ElementDayBefore.isEnabled();

            Assert.assertFalse(check,"day is passed ");
        }


    }


  //to check navigate in calender
    @Test(priority = 5)
    public void CalenderdatepickerValidation(){
        driver.findElement(By.xpath("/html/body/main/section/div/div/div[1]/div/div/div/a[2]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id='routeSlider']/div/div[2]/div/div/ul/li[1]/a")).click();

        WebElement CAL_after= driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span"));
        WebElement CAL_before= driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[1]/span"));

        if( !CAL_after.isEnabled() && CAL_before.isEnabled())
        {

            Assert.assertTrue(false,"error in behaviour of calender");

        }
    }




  //to check value in input field (travel from... to)
    @Test(priority = 6)
  

public void TravelValidation(){
    List<String> specialCharactersInSolr = Arrays.asList(new String[]{
            "+", "-", "&&", "||", "!", "(", ")", "{", "}", "[", "]", "^",
            "~", "*", "?", ":",});

    String fromvaildation= driver.findElement(By.name("fromPlaceName")).getText();
    String tovaildation= driver.findElement(By.name("toPlaceName")).getText();
    boolean form = fromvaildation.matches("[0-9]+");
    boolean to=tovaildation.matches("[0-9]+");

    if (fromvaildation.isEmpty() || tovaildation.isEmpty() ||specialCharactersInSolr.contains(fromvaildation)||
            specialCharactersInSolr.contains(tovaildation)||form||to){


        Assert.assertTrue(false,"invaild input");

    }




}




    @AfterMethod
    public void After() {


       EndPoint();
    }











}
