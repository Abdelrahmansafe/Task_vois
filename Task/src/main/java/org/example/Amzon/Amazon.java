package org.example.Amzon;

import Allfunction.DataNeeded;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Amazon extends DataNeeded {


    @BeforeMethod
    public void Before() {

        BeforeTest("https://www.amazon.com/");

    }

//to add item in  card and check is added
    @Test(priority = 1)
    public void AddItemInCard() {

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("car accessories");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).click();
        Assert.isTrue(CheckItemAdd(), "item not add sucessfully in card");
    }

    //to check input in search
    @Test(priority = 3)
    public void ValidTextBox() {
        List<String> specialCharactersInSolr = Arrays.asList(new String[]{
                "+", "-", "&&", "||", "!", "(", ")", "{", "}", "[", "]", "^",
                "~", "*", "?", ":",});
        WebElement SearchTextField = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        SearchTextField.sendKeys("111");

        String SearchValue = SearchTextField.getText();
        boolean result = SearchValue.matches("[0-9]+");
        if (SearchValue.isEmpty() || specialCharactersInSolr.contains(SearchValue) || result ) {
            System.out.println("please enter vaild text please");
            org.testng.Assert.assertTrue(false, "please enter vaild text please");


        }

    }

//add item from TodayDeals
    @Test(priority = 2)
    public void TodayDeals() {
        driver.findElement(By.linkText("Today's Deals")).click();
        driver.findElement(By.xpath("//*[@id='grid-main-container']/div[2]/span[3]/ul/li[19]/label/input")).click();
        driver.findElement(By.xpath("//*[@id='grid-main-container']/div[2]/span[3]/ul/li[20]/label/input")).click();
        driver.findElement(By.xpath("//*[@id='grid-main-container']/div[2]/span[6]/ul/li[2]/div/a/span")).click();
        driver.findElement(By.xpath("//*[@id='dealsGridLinkAnchor']/div/div[3]/div/ul/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id='grid-main-container']/div[3]/div/div[49]/div/div/div/a/div")).click();
        Assert.isTrue(CheckItemAdd(), "item not add sucessfully in card");
    }

    // element shared between two test cases 
    public boolean CheckItemAdd() {

        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        driver.findElement(By.xpath("//a[@class='a-button-text']")).click();
        return driver.findElement(By.xpath("//span[@class='a-truncate-cut']")).isDisplayed();

    }


    @AfterMethod
    public void After() {

        EndPoint();

    }


}
