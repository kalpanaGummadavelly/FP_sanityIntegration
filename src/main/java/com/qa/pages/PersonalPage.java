package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestBaseClass;

public class PersonalPage extends TestBaseClass {
	
	@FindBy(xpath="//button[@id='gotoCreatePlan']")WebElement addClient;
	@FindBy(id="create_new_plan_email_address")WebElement clientEmail;
	@FindBy(id="member_name")WebElement primaryFirstName;
	@FindBy(id="member_lastname")WebElement primaryLastName;
	@FindBy(xpath="//*[@id=\"primaryForm\"]/div[3]/div[1]")WebElement GenderMale;
	@FindBy(xpath="//*[@id=\"primaryForm\"]/div[3]/div[2]")WebElement GenderFemale;
	@FindBy(id="month_of_birth")WebElement monthOfBirth;
	@FindBy(id="year_of_birth")WebElement yearOfBirth;
	@FindBy(id="health_profile")WebElement healthProfile;
	@FindBy(id="create_new_plan_life_expectancy")WebElement lifeExpectancy;
	@FindBy(xpath="//*[@id=\"primaryForm\"]/div[7]/div[1]")WebElement tobaccoUserYes;
	@FindBy(xpath="//*[@id=\"primaryForm\"]/div[7]/div[2]")WebElement tobaccoUserNo;  
	@FindBy(id="create_new_plan_retirement_age")WebElement PrimaryRetirementAge;
	@FindBy(id="create_new_plan_current_zip_code")WebElement currentZipcode;
	@FindBy(id="create_new_plan_zip_code")WebElement zipcode;
	@FindBy(xpath="//*[@id='create_new_tax_filing_individual']")WebElement Individual;
	@FindBy(xpath="//*[@id='create_new_tax_filing_jointly']")WebElement jointly;
	//spouse details
	@FindBy(xpath="//input[@id='includeSpouse']")WebElement IncludeSpouse;
	@FindBy(id="spousemember_name")WebElement SpouseFirstName;
	@FindBy(id="spousemember_lastname")WebElement SpouseLastName;
	@FindBy(id="spousemale")WebElement Spousemale;
	@FindBy(xpath="//*[@id='female']")WebElement spousefemale;
	@FindBy(id="spousemonth_of_birth")WebElement SpousemonthOfBirth;
	@FindBy(id="spouseyear_of_birth")WebElement SpouseyearOfBirth;
	@FindBy(id="spousecreate_new_plan_health_profile")WebElement Spousehealth_profile;
	@FindBy(id="spousecreate_new_plan_life_expectancy")WebElement SpouseLifeExpectancy;
	@FindBy(id="spousetobacco_userYes")WebElement SpousetobaccoUserYes;
	@FindBy(id="spousetobacco_userNo")WebElement SpousetobaccoUserNo;  
	@FindBy(id="spousecreate_new_plan_retirement_age")WebElement SpouseRetirementAge;
	@FindBy(id="spousecreate_new_plan_current_zip_code")WebElement SpouseCurrentZipCode;
	@FindBy(id="spousecreate_new_plan_zip_code")WebElement SpouseRetirementZipCode;
//medicaretab
	@FindBy(xpath="//li[@id='medicare_collapsible_div']")WebElement medicarePage;
public PersonalPage() {
	PageFactory.initElements(driver, this);
}
public void individualCreatePlan(String clientEmailId,String priFirstName,String priLastName,String gender,String primonthOfBirth,
		String priyearOfBirth,String prihealthProfile,String prilifeExpectancy,String tobaccoUser,String primaryRetirementAge,String pricurrentZipcode,
		String priretzipcode,String taxFiling ) throws Exception {
	//addClient.click();
		clientEmail.sendKeys(clientEmailId);
		Thread.sleep(2000);
		primaryFirstName.sendKeys(priFirstName);
		primaryLastName.sendKeys(priLastName);
		if(gender.equalsIgnoreCase("male")) {
		GenderMale.click();;
		}else {
		GenderFemale.click();;
		}
		monthOfBirth.sendKeys(primonthOfBirth);
		yearOfBirth.sendKeys(priyearOfBirth);
		selectDropDownByVisibleText(healthProfile, prihealthProfile);
		lifeExpectancy.clear();
		lifeExpectancy.sendKeys(prilifeExpectancy);
		if(tobaccoUser.equalsIgnoreCase("Yes")) {
		tobaccoUserYes.click();;
		}else {
		tobaccoUserNo.click();
		}
		PrimaryRetirementAge.clear();
		PrimaryRetirementAge.sendKeys(primaryRetirementAge);
		currentZipcode.clear();
		currentZipcode.sendKeys(pricurrentZipcode);
		zipcode.clear();
		zipcode.sendKeys(priretzipcode);
		if(taxFiling.equalsIgnoreCase("Individual")) {
		jsClick(Individual);
		}else {
		jsClick(jointly);
		}
		TestBaseClass.takeScreenshot();
	}

public void familyCreatePlan(String clientEmailId,String priFirstName,String priLastName,String gender,String primonthOfBirth,
		String priyearOfBirth,String prihealthProfile,String prilifeExpectancy,String tobaccoUser,String primaryRetirementAge,String pricurrentZipcode,
		String priretzipcode,String taxFiling,String includeSpouse,String spouseFirstName,String spouseLastName,String spouseGender,String spousemonthOfBirth,
		String spouseyearOfBirth,String spousehealthProfile,String spouseLifeExpectancy,String spousetobaccoUser,String spouseRetirementAge,String spouseCurrentZipCode,
		String spouseRetirementZipCode ) throws Exception {
	
	//addClient.click();
	clientEmail.sendKeys(clientEmailId);
	Thread.sleep(2000);
	primaryFirstName.sendKeys(priFirstName);
	primaryLastName.sendKeys(priLastName);
	if(gender.equalsIgnoreCase("male")) {
	GenderMale.click();;
	}else {
	GenderFemale.click();;
	}
	monthOfBirth.sendKeys(primonthOfBirth);
	yearOfBirth.sendKeys(priyearOfBirth);
	selectDropDownByVisibleText(healthProfile, prihealthProfile);
	lifeExpectancy.clear();
	lifeExpectancy.sendKeys(prilifeExpectancy);
	if(tobaccoUser.equalsIgnoreCase("Yes")) {
	tobaccoUserYes.click();;
	}else {
	tobaccoUserNo.click();
	}
	PrimaryRetirementAge.clear();
	PrimaryRetirementAge.sendKeys(primaryRetirementAge);
	currentZipcode.clear();
	currentZipcode.sendKeys(pricurrentZipcode);
	zipcode.clear();
	zipcode.sendKeys(priretzipcode);
	if(taxFiling.equalsIgnoreCase("Individual")) {
	jsClick(Individual);
	}else {
	jsClick(jointly);
	}
	
	if(includeSpouse.equalsIgnoreCase("Yes")) {
		jsClick(IncludeSpouse);
		}
	SpouseFirstName.sendKeys(spouseFirstName);
	SpouseLastName.sendKeys(spouseLastName);
	if(spouseGender.equalsIgnoreCase("male")) {
		jsClick(Spousemale);
		}else {
		jsClick(spousefemale);
		}
	SpousemonthOfBirth.sendKeys(spousemonthOfBirth);
	SpouseyearOfBirth.sendKeys(spouseyearOfBirth);
	selectDropDownByVisibleText(Spousehealth_profile, spousehealthProfile);
	SpouseLifeExpectancy.clear();
	SpouseLifeExpectancy.sendKeys(spouseLifeExpectancy);
	if(spousetobaccoUser.equalsIgnoreCase("Yes")) {
		jsClick(SpousetobaccoUserYes);
		}else {
			jsClick(SpousetobaccoUserNo);
		}
	SpouseRetirementAge.clear();
	SpouseRetirementAge.sendKeys(spouseRetirementAge);
	SpouseCurrentZipCode.clear();
	SpouseCurrentZipCode.sendKeys(spouseCurrentZipCode);
	SpouseRetirementZipCode.clear();
	SpouseRetirementZipCode.sendKeys(spouseRetirementZipCode);
	TestBaseClass.takeScreenshot();

}

public void editPlanInPersonalPage(String primaryRetirementAge) throws Exception {
	PrimaryRetirementAge.clear();
	PrimaryRetirementAge.sendKeys(primaryRetirementAge);
	Thread.sleep(5000);
	TestBaseClass.takeScreenshot();
}

public void familyEditPlanInPersonalPage(String primaryRetirementAge,String spouseRetirementAge) throws Exception {
	PrimaryRetirementAge.clear();
	PrimaryRetirementAge.sendKeys(primaryRetirementAge);
	Thread.sleep(3000);
	SpouseRetirementAge.clear();
	SpouseRetirementAge.sendKeys(spouseRetirementAge);
	Thread.sleep(3000);
	TestBaseClass.takeScreenshot();
}





public MedicarePage medicareWindow() throws Exception {
	medicarePage.click();
	Thread.sleep(5000);
	return new MedicarePage();
}










}
