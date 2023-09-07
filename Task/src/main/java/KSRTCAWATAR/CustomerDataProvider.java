package KSRTCAWATAR;

import org.testng.annotations.DataProvider;

public class CustomerDataProvider {
    @DataProvider(name = "ForeignInfo")

    //date needed as Foreign
   public  Object[][] GetData(){


       Object[][] data={{"6789125987","Abdelrahman","abdosaber@gmail.com","20","Kolkata","06/07/2000"}};

       return  data;

   }

//date needed as public
    @DataProvider(name = "PublicInfo")
    public  Object[][] FAData(){


        Object[][] data={{"6789125978","seif","abdoseif@gmail.com","25"}};

        return  data;

    }



}
