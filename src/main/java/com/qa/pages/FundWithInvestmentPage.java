package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.utils.TestBaseClass;

public class FundWithInvestmentPage extends TestBaseClass {
 
  @FindBy(xpath="//body/div[@id='fund_with_investment']/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]")WebElement PrimaryPVforTotalHealthcareExpenses;
  @FindBy(xpath="//body/div[@id='fund_with_investment']/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]")WebElement PrimaryPVForExpensesToFund;
  @FindBy(xpath="//body/div[@id='fund_with_investment']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")WebElement ViewExpensesDropdown;
  @FindBy(xpath="//body/div[@id='fund_with_investment']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]/option[2]")WebElement ViewExpensesSpouse;
  //spouse
  @FindBy(xpath="//body/div[@id='fund_with_investment']/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]")WebElement SpousePVforTotalHealthcareExpenses;
  @FindBy(xpath="//body/div[@id='fund_with_investment']/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]")WebElement SpousePVForExpensesToFund;
	//LongTermCareExpensesWindow
  @FindBy(xpath="//body/div[@id='long_term_care_expenses']/div[1]/div[1]/ul[1]/li[4]/a[1]")WebElement LongTermCareExpenses;
  public static final String value= "$0";
public FundWithInvestmentPage() {
	PageFactory.initElements(driver, this);
}

public void primaryFundWithInvestment() throws Exception {
	


	//primaryPVforTotalHealthcareExpenses
	String primaryPVforTotalHealthcareExpenses =PrimaryPVforTotalHealthcareExpenses.getText();
	Assert.assertTrue(!primaryPVforTotalHealthcareExpenses.equals(value));
	System.out.println("the actual value is not zero for PrimaryPVforTotalHealthcareExpenses is " + primaryPVforTotalHealthcareExpenses);
	//primaryPVForExpensesToFund
	String primaryPVForExpensesToFund =PrimaryPVForExpensesToFund.getText();
	Assert.assertTrue(!primaryPVForExpensesToFund.equals(value));
	System.out.println("the actual value is not zero for PrimaryPVForExpensesToFund is " + primaryPVForExpensesToFund);
	TestBaseClass.takeScreenshot();
}

public void spouseFundWithInvestment() throws Exception {
	selectDropDownByValue(ViewExpensesDropdown, "spouse");
//	ViewExpensesDropdown.click();
//	ViewExpensesSpouse.click();
	Thread.sleep(6000);
	//primaryPVforTotalHealthcareExpenses
	String spousePVforTotalHealthcareExpenses =SpousePVforTotalHealthcareExpenses.getText();
	Assert.assertTrue(!spousePVforTotalHealthcareExpenses.equals(value));
	System.out.println("the actual value is not zero for SpousePVforTotalHealthcareExpenses is " + spousePVforTotalHealthcareExpenses);
	//primaryPVForExpensesToFund
	String spousePVForExpensesToFund =SpousePVForExpensesToFund.getText();
	Assert.assertTrue(!spousePVForExpensesToFund.equals(value));
	System.out.println("the actual value is not zero for SpousePVForExpensesToFund is " + spousePVForExpensesToFund);
	TestBaseClass.takeScreenshot();
}

public LongTermCareExpensesPage LongTermCareExpensesWindow() throws Exception {
	jsClick(LongTermCareExpenses);
	Thread.sleep(6000);
	 return new LongTermCareExpensesPage();
}




}