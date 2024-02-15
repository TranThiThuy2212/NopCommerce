package com.nopcommerce.user;

import com.beust.jcommander.Parameter;
import commons.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Function_01_Register extends BaseTest {
   @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browerName){
        Object driver = getBrowserDriver(browerName);
    }

    @Test
    public void TC_01(){

    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }


}
