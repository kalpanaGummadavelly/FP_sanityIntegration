package com.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestBaseClass;
import com.qa.utils.TestUtil;

public class MedicarePage extends TestBaseClass{
	
//	@FindBy(xpath="//li[@id='medicare_collapsible_div']")WebElement medicarePage;
	@FindBy(id="planstarusOK")WebElement planstatus;
	@FindBy(id="toYear0")WebElement toYear;
	@FindBy(xpath="//*[@id='plan_information_part_a_bought_radio_1']")WebElement partAPurchased;
	//Supplemental
	@FindBy(id="plan_information_medicare_select")WebElement supplemental;
    //dental
	@FindBy(id="plan_information_part_dental_checkbox")WebElement dental;
	//spousemagi
	@FindBy(id="toYearSpouse0")WebElement spousetoYear;
	@FindBy(xpath="//input[@id='spouseplan_information_part_a_bought_radio_1']']")WebElement SpousePartAPurchased;
	//Supplemental
		@FindBy(xpath="//*[@id='spouseplan_information_medicare_select']")WebElement SpouseSupplemental;
	    //dental
		@FindBy(id="spouseplan_information_part_dental_checkbox")WebElement SpouseDental;
		//Premedicare
		@FindBy(xpath="//*[@id=\"pre_medicare_collapsible_div\"]/div/a")WebElement Premedicare;

public MedicarePage() {
	PageFactory.initElements(driver, this);
}

public void primaryMedicare(String magi ) throws Exception {
//	medicarePage.click();
//	Thread.sleep(5000);
	jsClick(planstatus);
	int rows = Integer.parseInt(magi);
	for(int i=0, Index1=1;i<rows;i++,Index1++) {
		String toyear = "//*[@id=\"toYear" + i + "\"]";
		waitForElementToBeVisible(toYear);
		waitForElementToBeClickable(toYear);
		Thread.sleep(5000);
		selectDropDownByIndex(By.xpath(toyear),Index1);
		String incomeDropdown = "//*[@id=\"increment_" + i + "\"]//div[3]/select";
		selectDropDownByValue(By.xpath(incomeDropdown), Integer.toString(Index1));//TestUtil.getIncomeFamily().get(Index1));
		
	}

}
public void primaryPartA(String partApurchased) {
	if(partApurchased.equalsIgnoreCase("Yes")) {
	//	partAPurchased.click();	
		jsClick(partAPurchased);
	}
}
public void primarySupplemental(String supplementalPlan) {
	if(supplementalPlan.equalsIgnoreCase("No")) {
		System.out.println("supplementalPlan is not selected");
	}
	else {
	selectDropDownByValue(supplemental, supplementalPlan);
	}
}

public void primaryDental(String dentalPurchased) {
	if(dentalPurchased.equalsIgnoreCase("Yes")) {
		jsClick(dental);
	}
	TestBaseClass.takeScreenshot();
}
public void spouseMedicare(String magi,String spousemagi ) throws Exception {
//	medicarePage.click();
//	Thread.sleep(5000);
	jsClick(planstatus);
	int rows = Integer.parseInt(magi);
	for(int i=0, Index1=1;i<rows;i++,Index1++) {
		String toyear = "//*[@id=\"toYear" + i + "\"]";
		waitForElementToBeVisible(toYear);
		waitForElementToBeClickable(toYear);
		Thread.sleep(5000);
		selectDropDownByIndex(By.xpath(toyear),Index1);
		String incomeDropdown = "//*[@id=\"increment_" + i + "\"]//div[3]/select";
		selectDropDownByValue(By.xpath(incomeDropdown), Integer.toString(Index1));//TestUtil.getIncomeFamily().get(Index1));
		
	}
	int rows1 = Integer.parseInt(spousemagi);
	for(int i=0, Index=1;i<rows1;i++,Index++) {
		String spousetoyear = "//*[@id=\"toYearSpouse" + i + "\"]";
		waitForElementToBeVisible(spousetoYear);
		waitForElementToBeClickable(spousetoYear);
		
		selectDropDownByIndex(By.xpath(spousetoyear),Index);
		String incomeDropdown1 = "//*[@id=\"incrementSpouse_" + i + "\"]//div[3]/select";
		selectDropDownByValue(By.xpath(incomeDropdown1),Integer.toString(Index));//TestUtil.getIncomeFamily().get(Index));
		}

}
public void spousePartA(String spousePartApurchased) {
	if(spousePartApurchased.equalsIgnoreCase("Yes")) {
		SpousePartAPurchased.click();	
	}
}
public void spouseSupplemental(String spouseSupplemental) {
	if(spouseSupplemental.equalsIgnoreCase("No")) {
		System.out.println("supplementalPlan is not selected");
	}
	else {
	selectDropDownByValue(SpouseSupplemental, spouseSupplemental);
	}
}
public void spouseDental(String spouseDental) {
	if(spouseDental.equalsIgnoreCase("Yes")) {
		jsClick(SpouseDental);
	}
	TestBaseClass.takeScreenshot();	
}
public PreMedicarePage preMedicarewindow() throws Exception {
	jsClick(Premedicare);
	Thread.sleep(2000);
	return new PreMedicarePage();

}
}