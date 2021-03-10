package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.utils.TestBaseClass;

public class HomePage extends TestBaseClass {
	// addNewContentWithEmailId
	@FindBy(xpath = "//body/div[@id='plan_summary']/main[1]/div[2]/div[2]/div[1]/div[1]/button[1]/i[1]")
	WebElement addContent;
	@FindBy(id = "addNewContent_emailId")
	WebElement addcontentEmailId;
	@FindBy(id = "addNewContent_submit_button")
	WebElement addcontentSubmitButton;
	// clickOnPDFInAddContent
	@FindBy(xpath = "//body/div[@id='plan_summary']/main[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[1]/div[2]/a[1]")
	WebElement DzeeHealthFinancialSolutionsvideo;
	// addClient
	@FindBy(id = "gotoCreatePlan")
	WebElement addClient;
	// planSearch for edit plan
	@FindBy(xpath = "//input[@id='plans_search']")
	WebElement plansSearch;
	@FindBy(xpath = "//body[1]/div[8]/main[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[1]")
	WebElement plansSearchtable;
	@FindBy(xpath = "//i[@id='editPlan-0-0']")
	WebElement editPlan;
	// viewPlan
	@FindBy(xpath = "//i[@id='viewPlan-0-0']")
	WebElement viewPlan;
	// deletePlan
	@FindBy(xpath = "//i[@id='deletePlan-0-0']")
	WebElement deletePlan;
	@FindBy(xpath = "//button[@id='plan_summary_delete_confirm_okay_button']")
	WebElement deleteButton;

	// viewPlanPDF
	@FindBy(xpath = "//i[@id='viewPlanPDF-0-0']")
	WebElement viewPlanPDF;
	@FindBy(xpath = "//button[@id='pdf_submit']")
	WebElement generatePDF;
	// comparePlan
	@FindBy(xpath = "//tbody/tr[1]/td[2]/div[1]/label[1]")
	WebElement TopMostPlan0;
	@FindBy(xpath = "//tbody/tr[2]/td[2]/div[1]/label[1]")
	WebElement TopMostPlan1;
	@FindBy(xpath = "//button[@id='comparePlansIcon']")
	WebElement compare;
	// HelpIcon
	@FindBy(xpath = "//header/div[2]/div[1]/div[2]/div[3]/a[2]/i[1]")
	WebElement helpIcon;
	// settings
	@FindBy(xpath = "//header/div[2]/div[1]/div[2]/div[3]/a[3]/i[1]")
	WebElement setting;
	// changePassword
	@FindBy(xpath = "//a[contains(text(),'Change Password')]")
	WebElement chagePassword;
	@FindBy(xpath = "//body/div[@id='changepassword']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
	WebElement oldPassword;
	@FindBy(xpath = "//body/div[@id='changepassword']/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]")
	WebElement newPassword;

	@FindBy(xpath = "//body/div[@id='changepassword']/div[1]/div[1]/form[1]/div[1]/div[3]/input[1]")
	WebElement confirmNewPassword;
	@FindBy(xpath = "//body/div[@id='changepassword']/div[1]/div[1]/form[1]/div[2]/button[1]")
	WebElement submit;
	@FindBy(id = "change_password_form")
	WebElement assertCngPwd;
//	@FindBy(xpath="//body/div[@id='changepassword']/div[1]/div[1]/form[1]/div[2]/button[1]")WebElement submit;

	// comparePlan
	@FindBy(xpath = "//body[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[10]/td[2]")
	WebElement priTotalHealthcarePlanCostofPlan1;
	@FindBy(xpath = "//body[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[10]/td[3]")
	WebElement priTotalHealthcarePlanCostofPlan2;

	public static final String value = "0";

	public HomePage() {
		PageFactory.initElements(driver, this);

	}
//Actions

	public void addNewContentWithEmailId(String emailId) throws Exception {
		Thread.sleep(5000);
		addContent.click();
		Thread.sleep(2000);
		addcontentEmailId.sendKeys(emailId);
		Thread.sleep(2000);
		addcontentSubmitButton.click();
	}

	public PersonalPage addClient() {
		addClient.click();
		return new PersonalPage();
	}

	public void clickOnPDFInAddContent() throws Exception {
		// DzeeHealthFinancialSolutionsvideo.click();
		jsClick(DzeeHealthFinancialSolutionsvideo);
		checkNewTab();
	}

	public void Help() throws Exception {
		helpIcon.click();
		Thread.sleep(2000);

	}

	public void ChangePassword(String OldPassword, String NewPassword, String ConfirmNewPassword) {
		setting.click();
		chagePassword.click();
		oldPassword.sendKeys(OldPassword);
		newPassword.sendKeys(NewPassword);
		String NewPassword1 = newPassword.getText();
		System.out.println("new " + NewPassword1);
//	Assert.assertEquals(NewPassword1,"New Password should not be less than 8 characters long and should contain one number, one character and one special character");
		confirmNewPassword.sendKeys(ConfirmNewPassword);

		submit.click();

	}

	public PersonalPage primaryEditPlan(String clientEmailId) throws Exception {
		plansSearch.sendKeys(clientEmailId);
		pressEnterKey();
		Thread.sleep(2000);
		plansSearchtable.click();
		Thread.sleep(2000);
		editPlan.click();
		Thread.sleep(5000);
		return new PersonalPage();
	}

	public PersonalPage familyEditPlan(String clientEmailId) throws Exception {
		plansSearch.sendKeys(clientEmailId);
		pressEnterKey();
		Thread.sleep(2000);
		plansSearchtable.click();
		Thread.sleep(2000);
		editPlan.click();
		Thread.sleep(5000);
		return new PersonalPage();
	}

	public HealthCareExpensesPage primaryViewPlan(String clientEmailId) throws Exception {
		plansSearch.sendKeys(clientEmailId);
		pressEnterKey();
		Thread.sleep(2000);
		plansSearchtable.click();
		Thread.sleep(2000);
		viewPlan.click();
		Thread.sleep(10000);
		return new HealthCareExpensesPage();
	}

	public HealthCareExpensesPage familyViewPlan(String clientEmailId) throws Exception {
		plansSearch.sendKeys(clientEmailId);
		pressEnterKey();
		Thread.sleep(2000);
		plansSearchtable.click();
		Thread.sleep(2000);
		viewPlan.click();
		Thread.sleep(10000);
		return new HealthCareExpensesPage();
	}

	public void DeletePlan(String clientEmailId) throws Exception {

		plansSearch.sendKeys(clientEmailId);

		pressEnterKey();
		Thread.sleep(2000);
		plansSearchtable.click();
		Thread.sleep(2000);
		deletePlan.click();
		TestBaseClass.takeScreenshot();
		deleteButton.click();
		Thread.sleep(5000);
	}

	public void reportBuilder(String clientEmailId) throws Exception {
		plansSearch.sendKeys(clientEmailId);
		pressEnterKey();
		Thread.sleep(2000);
		plansSearchtable.click();
		Thread.sleep(2000);
		viewPlanPDF.click();
		Thread.sleep(10000);
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		generatePDF.click();
		Thread.sleep(10000);
		// Switch to new window opened
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
		TestBaseClass.takeScreenshot();
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

	}

	public void comparePlan(String clientEmailId) throws Exception {
		plansSearch.sendKeys(clientEmailId);
		pressEnterKey();
		Thread.sleep(2000);
		plansSearchtable.click();
		TopMostPlan0.click();
		Thread.sleep(200);
		TopMostPlan1.click();
		Thread.sleep(200);
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		compare.click();
		Thread.sleep(8000);
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
		  TestBaseClass.takeScreenshot(); TestBaseClass.scrollDown(); 
		  //plan1 PriTotalHealthcarePlanCostofPlan1 
		  String PriTotalHealthcarePlanCostofPlan1 =priTotalHealthcarePlanCostofPlan1.getText();
		  Assert.assertTrue(!PriTotalHealthcarePlanCostofPlan1.equals(value));
		  System.out.println("the actual value is not zero for PriTotalHealthcarePlanCostofPlan1 is " + PriTotalHealthcarePlanCostofPlan1); 
		  //Plan2PriTotalHealthcarePlanCostofPlan2 
		  String PriTotalHealthcarePlanCostofPlan2=priTotalHealthcarePlanCostofPlan2.getText();
		  Assert.assertTrue(!PriTotalHealthcarePlanCostofPlan2.equals(value));
		  System.out.
		  println("the actual value is not zero for PriTotalHealthcarePlanCostofPlan2 is "+ PriTotalHealthcarePlanCostofPlan2);
		  
		  /*
			 * // Grab the table WebElement table =
			 * driver.findElement(By.id("plan_comparison_table")); // Now get all the TR
			 * elements from the table List<WebElement> allRows =
			 * driver.findElements(By.tagName("tr")); // And iterate over them, getting the
			 * cells for (WebElement row : allRows) { List<WebElement> cells =
			 * row.findElements(By.tagName("td")); for (WebElement cell : cells) {
			 * WebElement THP =cell.findElement(By.xpath(
			 * "//body[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[10]/td[2]"
			 * )); String totalHealthCareExpenses = THP.getText();
			 * System.out.println("totalHealthCareExpenses is "+totalHealthCareExpenses); }
			 * }
			 */

		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
	}

}
