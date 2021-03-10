package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.utils.TestBaseClass;

public class HealthCareExpensesPage extends TestBaseClass {
	public static final String value= "$0";
	//primary HealthCareExpenses
	@FindBy(xpath="//*[@id='pv_at_retirement']")WebElement PvAtRetirement;
	@FindBy(id="yearly_total_expenses")WebElement totalHealthCareExpenses;
	@FindBy(id="yearly_total_expenses_expense_projection")WebElement totalSelectedExpenses;
	@FindBy(id="surcharge_pv_at_retirement")WebElement PresentValueOfSurchargeAtRetirement;
	@FindBy(id="surcharge_yearly_total_expenses")WebElement TotalIRMAASurcharge ;
	@FindBy(xpath="//div[@id='line_graph_healthcare_expenses_render_div']")WebElement HealthCareExpensesGraph;
	
	
	@FindBy(xpath="//*[@id=\"contentExpenses\"]/div/div/div[1]/div/div")WebElement ViewExpensesdropdown ;
	@FindBy(xpath="//*[@id=\"healthcareExpensesType\"]/option[2]")WebElement Spousedropdown ;
	
	//spouse HealthCareExpenses
	@FindBy(id="pv_at_retirement")WebElement spousePvAtRetirement;
	@FindBy(id="yearly_total_expenses")WebElement spouseTotalHealthCareExpenses;
	@FindBy(id="yearly_total_expenses_expense_projection")WebElement spouseTotalSelectedExpenses;
	@FindBy(id="surcharge_pv_at_retirement")WebElement spousePresentValueOfSurchargeAtRetirement;
	@FindBy(id="surcharge_yearly_total_expenses")WebElement spouseTotalIRMAASurcharge ;
	
	//MedicareBundles
	@FindBy(xpath="//a[@href=\"#MedicareBundles\"]")WebElement MedicareBundles;



public HealthCareExpensesPage() {
	PageFactory.initElements(driver, this);
}

public void primaryPvAtRetirement() throws Exception {
	String Pv_Retirement = PvAtRetirement.getText();
	System.out.println(Pv_Retirement);
	Assert.assertFalse(Pv_Retirement.equals("$0"));
	System.out.println("the actual value is not zero for primaryPv_at_retirement is " + Pv_Retirement);
	Thread.sleep(500);
}



public void primaryTotalHealthCareExpenses() throws Exception {
	String TotalHealthCareExpenses = totalHealthCareExpenses.getText();
	Assert.assertFalse(TotalHealthCareExpenses.equals(value));
	System.out.println("the actual value is not zero for primaryTotalHealthcareExpenses is " + TotalHealthCareExpenses);
	 Thread.sleep(500);
}

public void primaryTotalSelectedExpenses() throws Exception {
	String TotalSelectedExpenses = totalSelectedExpenses.getText();
	Assert.assertFalse(TotalSelectedExpenses.equals(value));
	System.out.println("the actual value is not zero for primaryTotalSelectedExpenses is" + TotalSelectedExpenses);
	 Thread.sleep(500);
	 TestBaseClass.takeScreenshot();
}

public void primaryPresentValueOfSurchargeAtRetirement(String magi) throws Exception {
	if(magi.equalsIgnoreCase("0")) {
		System.out.println("no SurchargeAtRetirement value for single magi");	
		}else {
	String presentValueOfSurchargeAtRetirement = PresentValueOfSurchargeAtRetirement.getText();
	Assert.assertFalse(presentValueOfSurchargeAtRetirement.equals(value));
	System.out.println("the actual value is not zero for primaryPresentValueOfSurchargeAtRetirement is" + presentValueOfSurchargeAtRetirement);
	 Thread.sleep(500);
		}
}

public void primaryTotalIRMAASurcharge(String magi) throws Exception {
	if(magi.equalsIgnoreCase("0")) {
	System.out.println("no totalIRMAASurcharge value for single magi");	
	}else {
	String totalIRMAASurcharge = TotalIRMAASurcharge.getText();
	Assert.assertFalse(totalIRMAASurcharge.equals(value));
	System.out.println("the actual value is not zero for totalIRMAASurcharge is" + totalIRMAASurcharge);
	TestBaseClass.takeScreenshot();
//	jsClick(ViewExpensesdropdown);
//	Spousedropdown.click();
    Thread.sleep(500);
	}
}

public void selectSpouse() throws Exception {
	jsClick(ViewExpensesdropdown);
//	ViewExpensesdropdown.click();
	Spousedropdown.click();
	 Thread.sleep(15000); 
}

public void spousePvAtRetirement() throws Exception {
	String spousePv_Retirement = spousePvAtRetirement.getText();
	Assert.assertFalse(spousePv_Retirement.equals(value));
	System.out.println("the actual value is not zero for spousePv_at_retirement is " + spousePv_Retirement);
	 Thread.sleep(500);
}

public void spouseTotalHealthCareExpenses() throws Exception {
	String spouseTotal_HealthCareExpenses = spouseTotalHealthCareExpenses.getText();
	Assert.assertFalse(spouseTotal_HealthCareExpenses.equals(value));
	System.out.println("the actual value is not zero for primaryTotalHealthcareExpenses is " + spouseTotal_HealthCareExpenses);
	 Thread.sleep(500);
}

public void spouseTotalSelectedExpenses() throws Exception {
	String SpouseTotalSelectedExpenses = spouseTotalSelectedExpenses.getText();
	Assert.assertFalse(SpouseTotalSelectedExpenses.equals(value));
	System.out.println("the actual value is not zero for spouseTotalSelectedExpenses is" + SpouseTotalSelectedExpenses);
	 Thread.sleep(500);
	 TestBaseClass.takeScreenshot();

}
public void spousePresentValueOfSurchargeAtRetirement(String magi) throws Exception {
	if(magi.equalsIgnoreCase("0")) {
		System.out.println("no totalIRMAASurcharge value for single magi");	
		}else {
	String SpousePresentValueOfSurchargeAtRetirement = spousePresentValueOfSurchargeAtRetirement.getText();
	Assert.assertFalse(SpousePresentValueOfSurchargeAtRetirement.equals(value));
	System.out.println("the actual value is not zero for spousePresentValueOfSurchargeAtRetirement is" + SpousePresentValueOfSurchargeAtRetirement);
	 Thread.sleep(500);
		}
}

public void spouseTotalIRMAASurcharge(String magi) throws Exception {
	if(magi.equalsIgnoreCase("0")) {
		System.out.println("no totalIRMAASurcharge value for single magi");	
		}else {
	String SpouseTotalIRMAASurcharge = spouseTotalIRMAASurcharge.getText();
	Assert.assertFalse(SpouseTotalIRMAASurcharge.equals(value));
	System.out.println("the actual value is not zero for spouseTotalIRMAASurcharge is" + SpouseTotalIRMAASurcharge);
	Thread.sleep(500);
	TestBaseClass.takeScreenshot();
		}
	 
}
public MedicareBundlesPage medicareBundlesWindow() throws Exception {
	jsClick(MedicareBundles);
	 Thread.sleep(6000);
	 return new MedicareBundlesPage();
}

}