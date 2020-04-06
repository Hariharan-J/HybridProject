package Hybridtestcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HybridPages.HybridLogin;
import hybridProjectBase.HybridProjectSpecificMethods;

public class Hybrid_TC002_EditLead extends HybridProjectSpecificMethods {
	
	/*@BeforeTest
	public void retrievedata() throws IOException {
		fetchdata();
	}*/
	
	@Test (dataProvider="getdata")
	public void editLead_testcase (String cn, String fn, String ln) throws InterruptedException {
		new HybridLogin(driver)
		.typeUsername()
		.typePassword()
		.clickLogin()
		.clickCRMSFA()
		.clickLeadsTab()
		.clickFindLeadsOption()
		.typeSearchFirstName(fn)
		.clickFindLeadsButton()
		.clickLeadOnGrid()
		.clickEditLeadButton()
		.updateCompanyName(cn)
		.clickUpdateButton()
		.verifyCompanyName(cn);
	}

}
