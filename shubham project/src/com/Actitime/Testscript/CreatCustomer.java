package com.Actitime.Testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Actitime.Generic.library.Baseclass;
import com.Actitime.Generic.library.FileLibrary;
import com.Actitime.POM.Homepage;
import com.Actitime.POM.Taskpage;

public class CreatCustomer extends Baseclass {

	
FileLibrary flib = new FileLibrary();
	
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		Homepage hp= new Homepage(driver);
		hp.getTasklnk().click();
		
		Taskpage tp = new Taskpage(driver);
		String Custname = flib.readDataFromExcelFile("Sheet1", 3, 1);
		String description = flib.readDataFromExcelFile("Sheet1", 3, 2);
		tp.completetask(Custname, description);
		
		String expected = Custname;
		String actualdate = driver.findElement(By.xpath("//div[@title='"+Custname+"']")).getText();
		SoftAssert s= new SoftAssert();
		s.assertEquals(expected, actualdate);
		
		Reporter.log("assertion pass",true);
		s.assertAll();
		
	}

}
