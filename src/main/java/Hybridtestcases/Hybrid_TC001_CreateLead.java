package Hybridtestcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HybridPages.HybridLogin;
import Hybridutils.ReadExcel;
import hybridProjectBase.HybridProjectSpecificMethods;

public class Hybrid_TC001_CreateLead extends HybridProjectSpecificMethods{
	
	@BeforeTest
	public void setData() {
		testcasename="TC001_CreateLead";
		testcasename="Create a new Lead on LeafTaps";	
		author="Hariharan";
		category="Smoke";
	}
	
	@Test (dataProvider="getdata")
	public void CreateLead_TC(String cn,String fn,String ln) {
		new HybridLogin(driver)
		.typeUsername()
		.typePassword()
		.clickLogin()
		.clickCRMSFA()
		.clickLeadsTab()
		.clickCreateLeadoption()
		.typeCompanyName(cn)
		.typeFirstName(fn)
		.typeLastName(ln)
		.clickCreateLeadButton()
		.verifyCompanyName(cn);
	}
	
	/*@DataProvider(name="getdata")
	public String[][] fetchdata() throws IOException {
		String[][] data = ReadExcel.dataset();
		return data;*/
	
		
	/*	String[][] data = new String[2][3];
		data[0][0] = "Double";
		data[0][1] = "Chart";
		data[0][2] = "Price";
		data[1][0] = "Life";
		data[1][1] = "Insurance";
		data[1][2] = "Corporation";
		return data;*/
}
