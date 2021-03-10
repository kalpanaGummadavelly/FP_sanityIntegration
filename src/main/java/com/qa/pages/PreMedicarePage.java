package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestBaseClass;

public class PreMedicarePage extends TestBaseClass {
	
	
	@FindBy(id="insurance_plan_information_metallic_plan")WebElement PlanType;
	@FindBy(id="spouseinsurance_plan_information_metallic_plan")WebElement spousePlanType;
	//longTermCarewindow
	@FindBy(xpath="//a[@href=\"#longTerm\"]")WebElement LongTermCare;

public PreMedicarePage() {
	PageFactory.initElements(driver, this);
}
public void primaryPreMedicare(String preMedPlanType) throws Exception {
	selectDropDownByValue(PlanType, preMedPlanType);
	Thread.sleep(2000);
	
}
public void spousePreMedicare(String spousePreMedPlanType) throws Exception {
	Thread.sleep(2000);
	selectDropDownByValue(spousePlanType, spousePreMedPlanType);
	
	
}
public LongTermCarePage longTermCarewindow() throws Exception {
	jsClick(LongTermCare);
	Thread.sleep(5000);
	return new LongTermCarePage();
}


}