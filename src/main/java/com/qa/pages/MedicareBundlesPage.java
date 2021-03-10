package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.utils.TestBaseClass;

public class MedicareBundlesPage extends TestBaseClass{
	
	//primaryABD
	@FindBy(xpath="//body[1]/div[21]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]")WebElement PrimaryABDTotalPremiums;
	@FindBy(xpath="//*[@id=\"healthcare_expenses_details_popup_div\"]/table/tbody[1]/tr[2]/td[3]")WebElement PrimaryABDTotalOOP;
	@FindBy(xpath="//*[@id=\"healthcare_expenses_details_popup_div\"]/table/tbody[1]/tr[2]/td[4]")WebElement PrimaryABDTotalExpenses;
	//primary ABDG
	@FindBy(xpath="//body[1]/div[21]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[7]/td[2]")WebElement PrimaryABDGTotalPremiums;
	@FindBy(xpath="//body[1]/div[21]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[7]/td[3]")WebElement PrimaryABDGTotalOOP;
	@FindBy(xpath="//body[1]/div[21]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[7]/td[4]")WebElement PrimaryABDGTotalExpenses;
	//primary ABDN
	@FindBy(xpath="//body[1]/div[21]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[9]/td[2]")WebElement PrimaryABDNTotalPremiums;		
	@FindBy(xpath="//body[1]/div[21]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[9]/td[3]")WebElement PrimaryABDNTotalOOP;
	@FindBy(xpath="//body[1]/div[21]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[9]/td[4]")WebElement PrimaryABDNTotalExpenses;
	//spouseABD
		@FindBy(xpath="//body[1]/div[21]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]")WebElement SpouseABDTotalPremiums;
		@FindBy(xpath="//body[1]/div[21]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]")WebElement SpouseABDTotalOOP;
		@FindBy(xpath="//body[1]/div[21]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]")WebElement SpouseABDTotalExpenses;
		//spouse ABDG
		@FindBy(xpath="//body[1]/div[21]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[7]/td[2]")WebElement SpouseABDGTotalPremiums;
		@FindBy(xpath="//body[1]/div[21]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[7]/td[3]")WebElement SpouseABDGTotalOOP;
		@FindBy(xpath="//body[1]/div[21]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[7]/td[4]")WebElement SpouseABDGTotalExpenses;
		//spouse ABDN
		@FindBy(xpath="//body[1]/div[21]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[9]/td[2]")WebElement SpouseABDNTotalPremiums;		
		@FindBy(xpath="//body[1]/div[21]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[9]/td[3]")WebElement SpouseABDNTotalOOP;
		@FindBy(xpath="//body[1]/div[21]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[9]/td[4]")WebElement SpouseABDNTotalExpenses;
//FundWithInvestmentwindow
		 @FindBy(xpath="//body/div[@id='fund_with_investment']/div[1]/div[1]/ul[1]/li[3]/a[1]")WebElement FundWithInvestment;
		 public static final String value= "$0";
	
public MedicareBundlesPage() {
	PageFactory.initElements(driver, this);
}

public void primaryABD() throws Exception {
	
	//premiums
	
	String priABDTotalPremiums = PrimaryABDTotalPremiums.getText();
	Assert.assertTrue(!priABDTotalPremiums.equals(value));
	System.out.println("the actual value is not zero for PrimaryABDTotalPremiums is " + priABDTotalPremiums);
	//OOP
	String priABDTotalOOP = PrimaryABDTotalOOP.getText();
	Assert.assertTrue(!priABDTotalOOP.equals(value));
	System.out.println("the actual value is not zero for PrimaryABDTotalOOP is " + priABDTotalOOP);
	
	String priABDTotalTotalExpenses = PrimaryABDTotalExpenses.getText();
	Assert.assertTrue(!priABDTotalTotalExpenses.equals(value));
	System.out.println("the actual value is not zero for PrimaryABDTotalExpenses is " + priABDTotalTotalExpenses);
	
}
public void primaryABDG(){
	//premiums
	
		String priABDGTotalPremiums = PrimaryABDGTotalPremiums.getText();
		Assert.assertTrue(!priABDGTotalPremiums.equals(value));
		System.out.println("the actual value is not zero for PrimaryABDGTotalPremiums is " + priABDGTotalPremiums);
		//OOP
		String priABDGTotalOOP = PrimaryABDGTotalOOP.getText();
		Assert.assertTrue(!priABDGTotalOOP.equals(value));
		System.out.println("the actual value is not zero for PrimaryABDGTotalOOP is " + priABDGTotalOOP);
		
		String priABDGTotalTotalExpenses = PrimaryABDGTotalExpenses.getText();
		Assert.assertTrue(!priABDGTotalTotalExpenses.equals(value));
		System.out.println("the actual value is not zero for PrimaryABDGTotalExpenses is " + priABDGTotalTotalExpenses);
		
}
public void primaryABDN(){
	//premiums
	
		String priABDNTotalPremiums = PrimaryABDNTotalPremiums.getText();
		Assert.assertTrue(!priABDNTotalPremiums.equals(value));
		System.out.println("the actual value is not zero for PrimaryABDNTotalPremiums is " + priABDNTotalPremiums);
		//OOP
		String priABDGNTotalOOP = PrimaryABDNTotalOOP.getText();
		Assert.assertTrue(!priABDGNTotalOOP.equals(value));
		System.out.println("the actual value is not zero for PrimaryABDNTotalOOP is " + priABDGNTotalOOP);
		
		String priABDNTotalTotalExpenses = PrimaryABDNTotalExpenses.getText();
		Assert.assertTrue(!priABDNTotalTotalExpenses.equals(value));
		System.out.println("the actual value is not zero for PrimaryABDNTotalExpenses is " + priABDNTotalTotalExpenses);
		TestBaseClass.takeScreenshot();
}
public void spouseABD() throws Exception {
	//premiums
	
	String spouseABDTotalPremiums = SpouseABDTotalPremiums.getText();
	Assert.assertTrue(!spouseABDTotalPremiums.equals(value));
	System.out.println("the actual value is not zero for SpouseABDTotalPremiums is " + spouseABDTotalPremiums);
	//OOP
	String spouseABDTotalOOP = SpouseABDTotalOOP.getText();
	Assert.assertTrue(!spouseABDTotalOOP.equals(value));
	System.out.println("the actual value is not zero for SpouseABDTotalOOP is " + spouseABDTotalOOP);
	
	String spouseABDTotalTotalExpenses = SpouseABDTotalExpenses.getText();
	Assert.assertTrue(!spouseABDTotalTotalExpenses.equals(value));
	System.out.println("the actual value is not zero for SpouseABDTotalExpenses is " + spouseABDTotalTotalExpenses);
	
}

public void spouseABDG(){
	//premiums
	
		String spouseABDGTotalPremiums = SpouseABDGTotalPremiums.getText();
		Assert.assertTrue(!spouseABDGTotalPremiums.equals(value));
		System.out.println("the actual value is not zero for SpouseABDGTotalPremiums is " + spouseABDGTotalPremiums);
		//OOP
		String spouseABDGTotalOOP = SpouseABDGTotalOOP.getText();
		Assert.assertTrue(!spouseABDGTotalOOP.equals(value));
		System.out.println("the actual value is not zero for SpouseABDGTotalOOP is " + spouseABDGTotalOOP);
		
		String spouseABDGTotalTotalExpenses = SpouseABDGTotalExpenses.getText();
		Assert.assertTrue(!spouseABDGTotalTotalExpenses.equals(value));
		System.out.println("the actual value is not zero for SpouseABDGTotalExpenses is " + spouseABDGTotalTotalExpenses);
		
}
public void spouseABDN(){
	//premiums
	
		String spouseABDNTotalPremiums = SpouseABDNTotalPremiums.getText();
		Assert.assertTrue(!spouseABDNTotalPremiums.equals(value));
		System.out.println("the actual value is not zero for SpouseABDNTotalPremiums is " + spouseABDNTotalPremiums);
		//OOP
		String spouseABDGNTotalOOP = SpouseABDNTotalOOP.getText();
		Assert.assertTrue(!spouseABDGNTotalOOP.equals(value));
		System.out.println("the actual value is not zero for SpouseABDNTotalOOP is " + spouseABDGNTotalOOP);
		
		String spouseABDNTotalTotalExpenses = SpouseABDNTotalExpenses.getText();
		Assert.assertTrue(!spouseABDNTotalTotalExpenses.equals(value));
		System.out.println("the actual value is not zero for SpouseABDNTotalExpenses is " + spouseABDNTotalTotalExpenses);
		TestBaseClass.takeScreenshot();
}


public FundWithInvestmentPage fundWithInvestmentWindow() throws Exception {
	jsClick(FundWithInvestment);
	Thread.sleep(8000);
	return new FundWithInvestmentPage();
	
}









}





