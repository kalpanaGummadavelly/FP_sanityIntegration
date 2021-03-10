package com.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.qa.dataProviders.DataProviders;
import com.qa.pages.FundWithInvestmentPage;
import com.qa.pages.HealthCareExpensesPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.LongTermCareExpensesPage;
import com.qa.pages.LongTermCarePage;
import com.qa.pages.MedicareBundlesPage;
import com.qa.pages.MedicarePage;
import com.qa.pages.PersonalPage;
import com.qa.pages.PreMedicarePage;
import com.qa.utils.ExtentReportsUtility;
import com.qa.utils.TestDataFunction;
import com.qa.utils.TestBaseClass;



public class FPSanityTestCasesTest extends ExtentReportsUtility  {
	LoginPage loginpage;
	HomePage homePage;
	TestBaseClass TestBaseClass = new TestBaseClass();
	PersonalPage personalPage =new PersonalPage() ;
	MedicarePage medicarePage = new MedicarePage();
	PreMedicarePage preMedicarePage = new PreMedicarePage();
	LongTermCarePage longTermCarePage= new LongTermCarePage();
	HealthCareExpensesPage healthCareExpensesPage = new HealthCareExpensesPage();
	MedicareBundlesPage medicareBundlesPage = new MedicareBundlesPage();
	FundWithInvestmentPage fundWithInvestmentPage = new FundWithInvestmentPage();
	LongTermCareExpensesPage longTermCareExpensesPage= new LongTermCareExpensesPage();
	ExtentReportsUtility extentReportsUtility =new ExtentReportsUtility();
	static TestDataFunction testDataFunction = new TestDataFunction();
	
	
	SoftAssert softassert = new SoftAssert();
	
	
	@BeforeMethod()
	public void setUp() throws Exception {
		TestBaseClass.initialization();
		loginpage = new LoginPage();
		homePage =loginpage.fplogin(TestBaseClass.loginMap.get("userName"), TestBaseClass.loginMap.get("passWord"),TestBaseClass.loginMap.get("userType"));
		Thread.sleep(1000);
		
	}
	
	
	
	@Test(priority = 0,dataProvider = "planData",dataProviderClass =DataProviders.class)
	public void familyCreatePlanTest(String Execute,String clientEmailId,String priFirstName,String priLastName,String gender,String primonthOfBirth,
			String priyearOfBirth,String prihealthProfile,String prilifeExpectancy,String tobaccoUser,String primaryRetirementAge,String pricurrentZipcode,
			String priretzipcode,String taxFiling,String includeSpouse,String spouseFirstName,String spouseLastName,String spouseGender,String spousemonthOfBirth,String spouseyearOfBirth,String spousehealthProfile,
			String spouseLifeExpectancy,String spousetobaccoUser,String spouseRetirementAge,String spouseCurrentZipCode,String spouseRetirementZipCode,
			String magi,String spousemagi,String partApurchased,String supplementalPlan,String dentalPurchased,String spousePartApurchased,String spouseSupplemental,String spouseDental,
			String qualityOfCare,String adultDayHealthCare,String inHomeCare,String nursingCare,
			String spouseQualityOfCare,String spouseAdultDayHealthCare,String spouseInHomeCare,
			String spouseNursingCare) throws Exception {
		
		logger.log(Status.INFO,
				"Plan details: " + "clientEmailId: " + clientEmailId + ", " + "priFirstName: " + priFirstName + ", "
						+ "priLastName: " + priLastName + ", " + "spouseFirstName: " + spouseFirstName + " ," +"spouseLastName: "+ "spouseLastName");
		
		personalPage = homePage.addClient();
		personalPage.familyCreatePlan(clientEmailId, priFirstName, priLastName, gender, primonthOfBirth, priyearOfBirth, prihealthProfile, prilifeExpectancy,
				tobaccoUser,primaryRetirementAge, pricurrentZipcode, priretzipcode, taxFiling, includeSpouse, spouseFirstName, spouseLastName, 
				spouseGender, spousemonthOfBirth, spouseyearOfBirth, spousehealthProfile, spouseLifeExpectancy, 
				spousetobaccoUser, spouseRetirementAge,spouseCurrentZipCode, spouseRetirementZipCode);
		medicarePage=personalPage.medicareWindow();	
		setMedicareData(magi, spousemagi, partApurchased, supplementalPlan, dentalPurchased, spousePartApurchased,
				spouseSupplemental);
		medicarePage.spouseDental(spouseDental);
		preMedicarePage=medicarePage.preMedicarewindow();
	//	preMedicarePage.primaryPreMedicare(preMedPlanType);
	//	preMedicarePage.spousePreMedicare(spousePreMedPlanType);
		longTermCarePage=preMedicarePage.longTermCarewindow();
		longTermCarePage.primaryLongTermCare(qualityOfCare,adultDayHealthCare,inHomeCare,nursingCare);
		longTermCarePage.spouseLongTermCare(spouseQualityOfCare, spouseAdultDayHealthCare, spouseInHomeCare, spouseNursingCare);
		healthCareExpensesPage=longTermCarePage.runAnalysis();
		healthCareExpensesPage.primaryPvAtRetirement();
		healthCareExpensesPage.primaryTotalHealthCareExpenses();
		healthCareExpensesPage.primaryTotalSelectedExpenses();
		healthCareExpensesPage.primaryPresentValueOfSurchargeAtRetirement(magi);
		healthCareExpensesPage.primaryTotalIRMAASurcharge(magi);
		healthCareExpensesPage.selectSpouse();
		healthCareExpensesPage.spousePvAtRetirement();
		healthCareExpensesPage.spouseTotalHealthCareExpenses();
		healthCareExpensesPage.spouseTotalSelectedExpenses();
		healthCareExpensesPage.spousePresentValueOfSurchargeAtRetirement(magi);
		healthCareExpensesPage.spouseTotalIRMAASurcharge(magi);
		medicareBundlesPage=healthCareExpensesPage.medicareBundlesWindow();
		medicareBundlesPage.primaryABD();
		medicareBundlesPage.primaryABDG();
		medicareBundlesPage.primaryABDN();
		medicareBundlesPage.spouseABD();
		medicareBundlesPage.spouseABDG();
		medicareBundlesPage.spouseABDN();
		fundWithInvestmentPage=medicareBundlesPage.fundWithInvestmentWindow();
		fundWithInvestmentPage.primaryFundWithInvestment();	
		fundWithInvestmentPage.spouseFundWithInvestment();
		longTermCareExpensesPage=fundWithInvestmentPage.LongTermCareExpensesWindow();
		longTermCareExpensesPage.primaryLongTermCareExpenses();
		longTermCareExpensesPage.spouseLongTermCareExpenses();
		longTermCareExpensesPage.repotBuilder();
		
		
	}
	@Test(priority = 1,dataProvider = "planData1",dataProviderClass =DataProviders.class )
	public void indCreatePlanTest(String Execute, String clientEmailId,String priFirstName,String priLastName,String gender,String primonthOfBirth,
			String priyearOfBirth,String prihealthProfile,String prilifeExpectancy,String tobaccoUser,String primaryRetirementAge,String pricurrentZipcode,
			String priretzipcode,String taxFiling,String magi,String partApurchased,String supplementalPlan,String dentalPurchased,
			String qualityOfCare,String adultDayHealthCare,String inHomeCare,String nursingCare) throws Exception {
		logger.log(Status.INFO,
				"Plan details: " + "clientEmailId: " + clientEmailId + ", " + "priFirstName: " + priFirstName + ", "
						+ "priLastName: " + priLastName);
		
		personalPage = homePage.addClient();
		personalPage.individualCreatePlan(clientEmailId,priFirstName,priLastName,gender,primonthOfBirth,
				priyearOfBirth,prihealthProfile,prilifeExpectancy,tobaccoUser,primaryRetirementAge,pricurrentZipcode,
				priretzipcode,taxFiling);
		medicarePage=personalPage.medicareWindow();
		medicarePage.primaryMedicare(magi);
		medicarePage.primaryPartA(partApurchased);
		medicarePage.primarySupplemental(supplementalPlan);
		medicarePage.primaryDental(dentalPurchased);
		preMedicarePage=medicarePage.preMedicarewindow();
//		preMedicarePage.primaryPreMedicare(preMedPlanType);
		longTermCarePage=preMedicarePage.longTermCarewindow();
		longTermCarePage.primaryLongTermCare(qualityOfCare,adultDayHealthCare,inHomeCare,nursingCare);
		healthCareExpensesPage=longTermCarePage.runAnalysis();
		healthCareExpensesPage.primaryPvAtRetirement();
		healthCareExpensesPage.primaryTotalHealthCareExpenses();
		healthCareExpensesPage.primaryTotalSelectedExpenses();
		healthCareExpensesPage.primaryPresentValueOfSurchargeAtRetirement(magi);
		healthCareExpensesPage.primaryTotalIRMAASurcharge(magi);
		medicareBundlesPage=healthCareExpensesPage.medicareBundlesWindow();
		medicareBundlesPage.primaryABD();
		medicareBundlesPage.primaryABDG();
		medicareBundlesPage.primaryABDN();
		fundWithInvestmentPage=medicareBundlesPage.fundWithInvestmentWindow();
		fundWithInvestmentPage.primaryFundWithInvestment();	
		longTermCareExpensesPage=fundWithInvestmentPage.LongTermCareExpensesWindow();
		longTermCareExpensesPage.primaryLongTermCareExpenses();
		longTermCareExpensesPage.repotBuilder();
	}
	
	@Test(priority = 2,dataProvider ="primaryEditPlanData",dataProviderClass = DataProviders.class)
	public void primaryEditPlanTest(String Execute, String clientEmailId,String primaryRetirementAge,String magi ) throws Exception {
		logger.log(Status.INFO,
				"Plan details: " + "primaryEditPlanTest");
		
		personalPage=homePage.primaryEditPlan(clientEmailId);
		personalPage.editPlanInPersonalPage(primaryRetirementAge);
		medicarePage=personalPage.medicareWindow();
		medicarePage.primaryMedicare(magi);
		preMedicarePage=medicarePage.preMedicarewindow();
		longTermCarePage=preMedicarePage.longTermCarewindow();
		healthCareExpensesPage=longTermCarePage.runAnalysis();
		healthCareExpensesPage.primaryPvAtRetirement();
		healthCareExpensesPage.primaryTotalHealthCareExpenses();
		healthCareExpensesPage.primaryTotalSelectedExpenses();
		healthCareExpensesPage.primaryPresentValueOfSurchargeAtRetirement(magi);
		healthCareExpensesPage.primaryTotalIRMAASurcharge(magi);
		medicareBundlesPage=healthCareExpensesPage.medicareBundlesWindow();
		medicareBundlesPage.primaryABD();
		medicareBundlesPage.primaryABDG();
		medicareBundlesPage.primaryABDN();
		fundWithInvestmentPage=medicareBundlesPage.fundWithInvestmentWindow();
		fundWithInvestmentPage.primaryFundWithInvestment();	
		longTermCareExpensesPage=fundWithInvestmentPage.LongTermCareExpensesWindow();
		longTermCareExpensesPage.primaryLongTermCareExpenses();
		longTermCareExpensesPage.repotBuilder();
	
	}
	@Test(priority = 3,dataProvider ="familyEditPlanData",dataProviderClass = DataProviders.class)
	public void familyEditPlanTest(String Execute, String clientEmailId,String primaryRetirementAge,String spouseRetirementAge,String magi ) throws Exception {
		logger.log(Status.INFO,
				"Plan details: " + "familyEditPlanData");
		
		
		personalPage=homePage.familyEditPlan(clientEmailId);
		personalPage.familyEditPlanInPersonalPage(primaryRetirementAge,spouseRetirementAge);
		medicarePage=personalPage.medicareWindow();
		medicarePage.primaryMedicare(magi);
		preMedicarePage=medicarePage.preMedicarewindow();
		longTermCarePage=preMedicarePage.longTermCarewindow();
		healthCareExpensesPage=longTermCarePage.runAnalysis();
		healthCareExpensesPage.primaryPvAtRetirement();
		healthCareExpensesPage.primaryTotalHealthCareExpenses();
		healthCareExpensesPage.primaryTotalSelectedExpenses();
		healthCareExpensesPage.selectSpouse();
		healthCareExpensesPage.spousePvAtRetirement();
		healthCareExpensesPage.spouseTotalHealthCareExpenses();
		healthCareExpensesPage.spouseTotalSelectedExpenses();
		medicareBundlesPage=healthCareExpensesPage.medicareBundlesWindow();
		medicareBundlesPage.primaryABD();
		medicareBundlesPage.primaryABDG();
		medicareBundlesPage.primaryABDN();
		medicareBundlesPage.spouseABD();
		medicareBundlesPage.spouseABDG();
		medicareBundlesPage.spouseABDN();
		fundWithInvestmentPage=medicareBundlesPage.fundWithInvestmentWindow();
		fundWithInvestmentPage.primaryFundWithInvestment();	
		fundWithInvestmentPage.spouseFundWithInvestment();
		longTermCareExpensesPage=fundWithInvestmentPage.LongTermCareExpensesWindow();
		longTermCareExpensesPage.primaryLongTermCareExpenses();
		longTermCareExpensesPage.spouseLongTermCareExpenses();
		longTermCareExpensesPage.repotBuilder();
	
	}
	
	
	@Test(priority = 4,dataProvider ="viewPlanData",dataProviderClass = DataProviders.class)
	public void primaryViewPlanTest(String Execute, String clientEmailId) throws Exception {
		logger.log(Status.INFO,
				"Plan details: " + "primaryViewPlanTest");
		
		healthCareExpensesPage=homePage.primaryViewPlan(clientEmailId);
		healthCareExpensesPage.primaryPvAtRetirement();
		healthCareExpensesPage.primaryTotalHealthCareExpenses();
		healthCareExpensesPage.primaryTotalSelectedExpenses();
		medicareBundlesPage=healthCareExpensesPage.medicareBundlesWindow();
		medicareBundlesPage.primaryABD();
		medicareBundlesPage.primaryABDG();
		medicareBundlesPage.primaryABDN();
		fundWithInvestmentPage=medicareBundlesPage.fundWithInvestmentWindow();
		fundWithInvestmentPage.primaryFundWithInvestment();	
		longTermCareExpensesPage=fundWithInvestmentPage.LongTermCareExpensesWindow();
		longTermCareExpensesPage.primaryLongTermCareExpenses();
		longTermCareExpensesPage.repotBuilder();	
	}
	@Test(priority = 5,dataProvider ="familyViewPlanData",dataProviderClass = DataProviders.class)
	public void familyViewPlanTest(String Execute, String clientEmailId) throws Exception {
		logger.log(Status.INFO,
				"Plan details: " + "familyViewPlanTest");
		
		healthCareExpensesPage=homePage.primaryViewPlan(clientEmailId);
		healthCareExpensesPage.primaryPvAtRetirement();
		healthCareExpensesPage.primaryTotalHealthCareExpenses();
		healthCareExpensesPage.primaryTotalSelectedExpenses();
		healthCareExpensesPage.selectSpouse();
		healthCareExpensesPage.spousePvAtRetirement();
		healthCareExpensesPage.spouseTotalHealthCareExpenses();
		healthCareExpensesPage.spouseTotalSelectedExpenses();
		medicareBundlesPage=healthCareExpensesPage.medicareBundlesWindow();
		medicareBundlesPage.primaryABD();
		medicareBundlesPage.primaryABDG();
		medicareBundlesPage.primaryABDN();
		medicareBundlesPage.spouseABD();
		medicareBundlesPage.spouseABDG();
		medicareBundlesPage.spouseABDN();
		fundWithInvestmentPage=medicareBundlesPage.fundWithInvestmentWindow();
		fundWithInvestmentPage.primaryFundWithInvestment();	
		fundWithInvestmentPage.spouseFundWithInvestment();
		longTermCareExpensesPage=fundWithInvestmentPage.LongTermCareExpensesWindow();
		longTermCareExpensesPage.primaryLongTermCareExpenses();
		longTermCareExpensesPage.spouseLongTermCareExpenses();
		longTermCareExpensesPage.repotBuilder();
	
	}
	@Test(priority = 8,dataProvider ="deletePlanData",dataProviderClass = DataProviders.class)
	public void deletePlanTest(String Execute,String clientEmailId) throws Exception {
		logger.log(Status.INFO,
				"Plan details: " + "deletePlanTest");
		
		homePage.DeletePlan(clientEmailId);
		
	}
	@Test(priority = 6,dataProvider ="reportBuilder",dataProviderClass = DataProviders.class)
	public void reportBuilderTest(String Execute,String clientEmailId ) throws Exception {
		logger.log(Status.INFO,
				"Plan details: " + "reportBuilderTest");
		
		homePage.reportBuilder(clientEmailId);
	}
    @Test(priority = 7,dataProvider ="comparePlan",dataProviderClass = DataProviders.class)
    public void comparePlanTest(String Execute,String clientEmailId) throws Exception {
    	logger.log(Status.INFO,
				"Plan details: " + "comparePlanTest");
		
    	homePage.comparePlan(clientEmailId);
    }
	private void setMedicareData(String magi, String spousemagi, String partApurchased, String supplementalPlan,
			String dentalPurchased, String spousePartApurchased, String spouseSupplemental) throws Exception {
		medicarePage.spouseMedicare(magi,spousemagi);
		medicarePage.primaryPartA(partApurchased);
		medicarePage.primarySupplemental(supplementalPlan);
		medicarePage.primaryDental(dentalPurchased);
		medicarePage.spousePartA(spousePartApurchased);
		medicarePage.spouseSupplemental(spouseSupplemental);
		
	}
	
	
	
	@AfterMethod()
	public void tearDown() {
		TestBaseClass.driver.quit();	
	}
	
}



