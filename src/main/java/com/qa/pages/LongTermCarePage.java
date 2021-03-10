package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestBaseClass;

public class LongTermCarePage extends TestBaseClass {
	
	
@FindBy(id="primary_currentLifeStyleExpenses")WebElement QualityOfCare;
@FindBy(id="numberOfAdultDayHealthCareLTCYears")WebElement AdultDayHealthCare;
@FindBy(id="primary_numberOfLTCYears")WebElement InHomeCare;
@FindBy(id="care_type_radio")WebElement NursingCare;
@FindBy(id="spouse_currentLifeStyleExpenses")WebElement SpouseQualityOfCare;
@FindBy(id="spousenumberOfAdultDayHealthCareLTCYears")WebElement SpouseAdultDayHealthCare;
@FindBy(id="spouse_numberOfLTCYears")WebElement SpouseInHomeCare;
@FindBy(id="spousecare_type_radio")WebElement SpouseNursingCare;
@FindBy(xpath="//button[@id='submitButtonShowPopupClick']")WebElement RunAnalysis;
@FindBy(xpath="//a[@id='medicare_information_show_popup_no_button']")WebElement RunAnalysisWindow;



public LongTermCarePage() {
	PageFactory.initElements(driver, this);
}

public void primaryLongTermCare(String qualityOfCare,String adultDayHealthCare,String inHomeCare,String nursingCare) throws Exception {
//	LongTermCare.click();
	selectDropDownByVisibleText(QualityOfCare, qualityOfCare);
	selectDropDownByValue(AdultDayHealthCare, adultDayHealthCare);
	Thread.sleep(2000);
	selectDropDownByValue(InHomeCare, inHomeCare);
	selectDropDownByValue(NursingCare, nursingCare);
	TestBaseClass.takeScreenshot();
}

public void spouseLongTermCare(String spouseQualityOfCare,String spouseAdultDayHealthCare,String spouseInHomeCare,String spouseNursingCare) throws Exception {
	selectDropDownByVisibleText(SpouseQualityOfCare, spouseQualityOfCare);
	selectDropDownByValue(SpouseAdultDayHealthCare, spouseAdultDayHealthCare);
	selectDropDownByValue(SpouseInHomeCare, spouseInHomeCare);
	selectDropDownByValue(SpouseNursingCare, spouseNursingCare);
	Thread.sleep(2000);
	TestBaseClass.takeScreenshot();
	}

public HealthCareExpensesPage runAnalysis() throws Exception {
	RunAnalysis.click();
	RunAnalysisWindow.click();
	Thread.sleep(10000);
	return new HealthCareExpensesPage();

}




}