package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.utils.TestBaseClass;

public class LongTermCareExpensesPage extends TestBaseClass{
	
	@FindBy(xpath="//div[@id='total_ltc_pv_for_primary']")WebElement PrimaryTotalPresentValueExpenses;
	@FindBy(xpath="//div[@id='total_ltc_fv_for_primary']")WebElement PrimaryTotalFutureValueExpenses;
	//primaryAdultcare
	@FindBy(xpath="//td[@id='primary_year_of_care_adult_day']")WebElement PrimaryAdultDayYearsOfCare;
	@FindBy(xpath="//td[@id='primary_ltc_adult_day_future_value']")WebElement PrimaryAdultDayCareFutureValue;
	@FindBy(xpath="//td[@id='primary_ltc_adult_day_present_value']")WebElement PrimaryAdultDayCarePresentValue;
	//primaryInHomeCare
	@FindBy(xpath="//td[@id='primary_year_of_care_home']")WebElement PrimaryInHomeCareYearsOfCare;
	@FindBy(xpath="//td[@id='primary_ltc_home_care_future_value']")WebElement PrimaryInHomeCareFutureValue;
	@FindBy(xpath="//td[@id='primary_ltc_nursing_future_value']")WebElement PrimaryInHomeCarePresentValue;
	//primaryNursingCare
	@FindBy(xpath="//td[@id='primary_year_of_care_nursing']")WebElement PrimaryNursingCareYearsOfCare;
	@FindBy(xpath="//td[@id='primary_ltc_nursing_future_value']")WebElement PrimaryNursingCareFutureValue;
	@FindBy(xpath="//td[@id='primary_ltc_nursing_present_value']")WebElement PrimaryNursingCarePresentValue;
	//spouseAdultcare
	@FindBy(xpath="//td[@id='spouse_year_of_care_adult_day']")WebElement SpouseAdultDayYearsOfCare;
	@FindBy(xpath="//td[@id='spouse_ltc_adult_day_future_value']")WebElement SpouseAdultDayCareFutureValue;
	@FindBy(xpath="//td[@id='spouse_ltc_adult_day_present_value']")WebElement SpouseAdultDayCarePresentValue;
	//spouseInHomeCare
	@FindBy(xpath="//td[@id='spouse_year_of_care_home']")WebElement SpouseInHomeCareYearsOfCare;
	@FindBy(xpath="//td[@id='spouse_ltc_home_care_future_value']")WebElement SpouseInHomeCareFutureValue;
	@FindBy(xpath="//td[@id='spouse_ltc_home_care_present_value']")WebElement SpouseInHomeCarePresentValue;
	//spouseNursingCare
	@FindBy(xpath="//td[@id='spouse_year_of_care_nursing']")WebElement SpouseNursingCareYearsOfCare;
	@FindBy(xpath="//td[@id='spouse_ltc_nursing_future_value']")WebElement SpouseNursingCareFutureValue;
	@FindBy(xpath="//td[@id='spouse_ltc_nursing_present_value']")WebElement SpouseNursingCarePresentValue;
	
	
	
	
	@FindBy(xpath="//div[@id='total_ltc_pv_for_spouse']")WebElement SpouseTotalPresentValueExpenses;
	@FindBy(xpath="//div[@id='total_ltc_fv_for_spouse']")WebElement SpouseTotalFutureValueExpenses;
	//reportBuilder
	@FindBy(xpath="//body/div[@id='pdf_generator_option_page']/div[1]/div[1]/ul[1]/li[5]/a[1]")WebElement RepotBuilder;
	 public static final String value= "$0";

	public LongTermCareExpensesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void primaryLongTermCareExpenses() throws Exception {
		
		String primaryTotalPresentValueExpenses=PrimaryTotalPresentValueExpenses.getText();
		Assert.assertFalse(primaryTotalPresentValueExpenses.equals(value));
		System.out.println("the actual value is not zero for PrimaryTotalPresentValueExpenses is" + primaryTotalPresentValueExpenses);
		String primaryTotalFutureValueExpenses=PrimaryTotalFutureValueExpenses.getText();
		Assert.assertFalse(primaryTotalFutureValueExpenses.equals(value));
		System.out.println("the actual value is not zero for PrimaryTotalFutureValueExpenses is" + primaryTotalFutureValueExpenses);
				
		if(!PrimaryAdultDayYearsOfCare.equals("0")) {
		String primaryAdultDayCareFutureValue=PrimaryAdultDayCareFutureValue.getText();
		Assert.assertFalse(primaryAdultDayCareFutureValue.equals(value));
		System.out.println("the actual value is not zero for primaryAdultDayCareFutureValue is" + primaryAdultDayCareFutureValue);
		String primaryAdultDayCarePresentValue=PrimaryAdultDayCarePresentValue.getText();
		Assert.assertFalse(primaryAdultDayCarePresentValue.equals(value));
		System.out.println("the actual value is not zero for primaryAdultDayCarePresentValue is" + primaryAdultDayCarePresentValue);
		}
		else {
			String primaryAdultDayCareFutureValue=PrimaryAdultDayCareFutureValue.getText();
			Assert.assertTrue(primaryAdultDayCareFutureValue.equals(value));
			System.out.println("the actual value is not zero for primaryAdultDayCareFutureValue is" + primaryAdultDayCareFutureValue);
			String primaryAdultDayCarePresentValue=PrimaryAdultDayCarePresentValue.getText();
			Assert.assertTrue(primaryAdultDayCarePresentValue.equals(value));
			System.out.println("the actual value is not zero for primaryAdultDayCarePresentValue is" + primaryAdultDayCarePresentValue);
		}
		
		if(!PrimaryInHomeCareYearsOfCare.equals("0")) {
			String primaryInHomeCareFutureValue=PrimaryInHomeCareFutureValue.getText();
			Assert.assertFalse(primaryInHomeCareFutureValue.equals(value));
			System.out.println("the actual value is not zero for primaryInHomeCareFutureValue is" + primaryInHomeCareFutureValue);
			String primaryInHomeCarePresentValue=PrimaryInHomeCarePresentValue.getText();
			Assert.assertFalse(primaryInHomeCarePresentValue.equals(value));
			System.out.println("the actual value is not zero for primaryAdultDayCarePresentValue is" + primaryInHomeCarePresentValue);
			}
			else {
				String primaryInHomeCareFutureValue=PrimaryInHomeCareFutureValue.getText();
				Assert.assertTrue(primaryInHomeCareFutureValue.equals(value));
				System.out.println("the actual value is not zero for primaryInHomeCareFutureValue is" + primaryInHomeCareFutureValue);
				String primaryInHomeCarePresentValue=PrimaryInHomeCarePresentValue.getText();
				Assert.assertTrue(primaryInHomeCarePresentValue.equals(value));
				System.out.println("the actual value is not zero for primaryAdultDayCarePresentValue is" + primaryInHomeCarePresentValue);
			}
		if(!PrimaryNursingCareYearsOfCare.equals("0")) {
			String primaryNursingCareFutureValue=PrimaryNursingCareFutureValue.getText();
			Assert.assertFalse(primaryNursingCareFutureValue.equals(value));
			System.out.println("the actual value is not zero for primaryNursingCareFutureValue is" + primaryNursingCareFutureValue);
			String primaryNursingCarePresentValue=PrimaryNursingCarePresentValue.getText();
			Assert.assertFalse(primaryNursingCarePresentValue.equals(value));
			System.out.println("the actual value is not zero for primaryNursingCarePresentValue is" + primaryNursingCarePresentValue);
			}
			else {
				String primaryNursingCareFutureValue=PrimaryNursingCareFutureValue.getText();
				Assert.assertFalse(primaryNursingCareFutureValue.equals(value));
				System.out.println("the actual value is not zero for primaryNursingCareFutureValue is" + primaryNursingCareFutureValue);
				String primaryNursingCarePresentValue=PrimaryNursingCarePresentValue.getText();
				Assert.assertFalse(primaryNursingCarePresentValue.equals(value));
				System.out.println("the actual value is not zero for primaryNursingCarePresentValue is" + primaryNursingCarePresentValue);
			}
		
		TestBaseClass.takeScreenshot();
		
	}
	
	
	
	
	
	
	public void spouseLongTermCareExpenses() {
		String spouseTotalPresentValueExpenses=SpouseTotalPresentValueExpenses.getText();
		Assert.assertFalse(spouseTotalPresentValueExpenses.equals(value));
		System.out.println("the actual value is not zero for SpouseTotalPresentValueExpenses is" + spouseTotalPresentValueExpenses);
		String spouseTotalFutureValueExpenses=SpouseTotalFutureValueExpenses.getText();
		Assert.assertFalse(spouseTotalFutureValueExpenses.equals(value));
		System.out.println("the actual value is not zero for SpouseTotalFutureValueExpenses is" + spouseTotalFutureValueExpenses);
	 	
		if(!SpouseAdultDayYearsOfCare.equals("0")) {
			String spouseAdultDayCareFutureValue=SpouseAdultDayCareFutureValue.getText();
			Assert.assertFalse(spouseAdultDayCareFutureValue.equals(value));
			System.out.println("the actual value is not zero for spouseAdultDayCareFutureValue is" + spouseAdultDayCareFutureValue);
			String spouseAdultDayCarePresentValue=SpouseAdultDayCarePresentValue.getText();
			Assert.assertFalse(spouseAdultDayCarePresentValue.equals(value));
			System.out.println("the actual value is not zero for spouseAdultDayCarePresentValue is" + spouseAdultDayCarePresentValue);
			}
			else {
				String spouseAdultDayCareFutureValue=SpouseAdultDayCareFutureValue.getText();
				Assert.assertFalse(spouseAdultDayCareFutureValue.equals(value));
				System.out.println("the actual value is not zero for spouseAdultDayCareFutureValue is" + spouseAdultDayCareFutureValue);
				String spouseAdultDayCarePresentValue=SpouseAdultDayCarePresentValue.getText();
				Assert.assertFalse(spouseAdultDayCarePresentValue.equals(value));
				System.out.println("the actual value is not zero for spouseAdultDayCarePresentValue is" + spouseAdultDayCarePresentValue);
			}
			
			if(!SpouseInHomeCareYearsOfCare.equals("0")) {
				String spouseInHomeCareFutureValue=SpouseInHomeCareFutureValue.getText();
				Assert.assertFalse(spouseInHomeCareFutureValue.equals(value));
				System.out.println("the actual value is not zero for spouseInHomeCareFutureValue is" + spouseInHomeCareFutureValue);
				String spouseInHomeCarePresentValue=SpouseInHomeCarePresentValue.getText();
				Assert.assertFalse(spouseInHomeCarePresentValue.equals(value));
				System.out.println("the actual value is not zero for spouseInHomeCarePresentValue is" + spouseInHomeCarePresentValue);
				}
				else {
					String spouseInHomeCareFutureValue=SpouseInHomeCareFutureValue.getText();
					Assert.assertFalse(spouseInHomeCareFutureValue.equals(value));
					System.out.println("the actual value is not zero for spouseInHomeCareFutureValue is" + spouseInHomeCareFutureValue);
					String spouseInHomeCarePresentValue=SpouseInHomeCarePresentValue.getText();
					Assert.assertFalse(spouseInHomeCarePresentValue.equals(value));
					System.out.println("the actual value is not zero for spouseInHomeCarePresentValue is" + spouseInHomeCarePresentValue);
				}
			if(!SpouseNursingCareYearsOfCare.equals("0")) {
				String spouseNursingCareFutureValue=SpouseNursingCareFutureValue.getText();
				Assert.assertFalse(spouseNursingCareFutureValue.equals(value));
				System.out.println("the actual value is not zero for spouseNursingCareFutureValue is" + spouseNursingCareFutureValue);
				String spouseNursingCarePresentValue=SpouseNursingCarePresentValue.getText();
				Assert.assertFalse(spouseNursingCarePresentValue.equals(value));
				System.out.println("the actual value is not zero for spouseNursingCarePresentValue is" + spouseNursingCarePresentValue);
				}
				else {
					String spouseNursingCareFutureValue=SpouseNursingCareFutureValue.getText();
					Assert.assertFalse(spouseNursingCareFutureValue.equals(value));
					System.out.println("the actual value is not zero for spouseNursingCareFutureValue is" + spouseNursingCareFutureValue);
					String spouseNursingCarePresentValue=SpouseNursingCarePresentValue.getText();
					Assert.assertFalse(spouseNursingCarePresentValue.equals(value));
					System.out.println("the actual value is not zero for spouseNursingCarePresentValue is" + spouseNursingCarePresentValue);
				}
			
			TestBaseClass.takeScreenshot();
	}
	
	
	public void repotBuilder() throws Exception {
		jsClick(RepotBuilder);
		Thread.sleep(10000);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
