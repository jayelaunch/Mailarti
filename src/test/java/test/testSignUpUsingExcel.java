package test;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SignUp;


import java.io.FileInputStream;
import java.io.IOException;

public class testSignUpUsingExcel {
    public WebDriver driver;


    @Test (dataProvider = "getData")
    public void fillFormAndSubmit(String fname,String mname,String lname,String email,String phone,String username,String password,String repassword) throws IOException, InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ocushare-dev-portal.azurewebsites.net/register");
        SignUp page = new SignUp(driver);

        page.enterTextInTextBox1(fname);
        page.enterTextInTextBox2(mname);
        page.enterTextInTextBox4(email);
        page.enterTextInPhone(phone);
        page.enterTextInTextBox5(password);
        page.enterTextInTextBox6(repassword);
        page.clickSubmitButton();

        Thread.sleep(1500);
      /*  login lgn=new login(driver);
        lgn.screenshot();
        */


        // Add assertions or verification steps as needed
    }

    @DataProvider
    Object[][] getData() throws IOException {

        // 1 . read the file
        FileInputStream fis = new FileInputStream("Data/SignUp.xls");

        // 2. convert this file object into workbook object
        HSSFWorkbook workbook = new HSSFWorkbook(fis);


        // 3. select the sheet
        HSSFSheet sheet = workbook.getSheet("Sheet1");

        // 4. count the active rows
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount-1][colCount];

        for (int i=0; i<rowCount-1 ; i++)
        {
            HSSFRow row = sheet.getRow(i+1);

            for(int j=0 ;j<colCount ; j++)
            {

                HSSFCell cell = row.getCell(j);
             /*   if (cell==null)
                    data[i][j] ="";
                else {
                    cell.setCellType(CellType.STRING);
                    data[i][j] = cell.toString().trim();
                   }
              */
                if (cell==null)
                    data[i][j] ="";
                else{
                    cell.setCellType(CellType.STRING);
                    data[i][j] = cell.toString();
                }


            }

        }

        return data;
    }


}

