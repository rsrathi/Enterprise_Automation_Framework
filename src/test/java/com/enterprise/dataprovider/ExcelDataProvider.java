package com.enterprise.dataprovider;

import org.testng.annotations.DataProvider;

import com.enterprise.constants.FrameworkConstants;
import com.enterprise.utils.ExcelUtils;

public class ExcelDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        try (ExcelUtils excel = new ExcelUtils(
                FrameworkConstants.TESTDATA_PATH + "LoginData.xlsx")) {

            excel.setSheet("Sheet1");

            return excel.getSheetData();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to load login data.",
                    e);

        }

    }

}