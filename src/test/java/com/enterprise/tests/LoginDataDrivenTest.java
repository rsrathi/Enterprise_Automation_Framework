package com.enterprise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.enterprise.base.BaseTest;
import com.enterprise.dataprovider.ExcelDataProvider;
import com.enterprise.pages.DashboardPage;
import com.enterprise.pages.LoginPage;

public class LoginDataDrivenTest extends BaseTest {

    @Test(dataProvider = "loginData",dataProviderClass = ExcelDataProvider.class)
    public void verifyLoginWithExcel(String username,String password) {

        LoginPage loginPage = new LoginPage(driver);

        DashboardPage dashboard =loginPage.login(username, password);
    
        	//Assert.assertTrue(dashboard.isDashboardDisplayed());
      

        

    }

}