package Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;

public class Assignment_8_Pages {

    public String pageUrl = "https://www.bankofamerica.com/credit-cards/#filter";
// First click
    public By customizedCashRewardClick= new By.ByXPath("//a[contains(@id,'home_4060812')]");

    public By firstName = new By.ByCssSelector("#customerFirstName");

    public By middleName = new By.ByCssSelector("#customerMiddleName");

    public By lastName = new By.ByCssSelector("#customerLastName");

    public By suffix = new By.ByCssSelector("#customerNameSuffix");

    public By address1 = new By.ByXPath("//*[@id=\"customerResidentialAddressOne\"]");

    public By address2 = new By.ByXPath("//*[@id=\"customerResidentialAddressTwo\"]");

    public By city = new By.ByCssSelector("#customerAddressCity");

    public By state = new By.ByCssSelector("#customerAddressState option");

    public By zipCode = new By.ByCssSelector("#customerAddressInput");

    public By phoneNumber = new By.ByCssSelector("#customerPrimaryPhoneNumber");

    public By typeOfPhone = new By.ByCssSelector("#phoneNumberMobile");

    public By email = new By.ByCssSelector("#customerEmailAddress");

    public By saveAndContinue = new By.ByCssSelector("#icaiContinueButton");

    //page 2
    public By usCitizen = new By.ByCssSelector("#customerUsCitizenYes");

    public By ssNumber = new By.ByCssSelector("#customerSocialSecurityNumber");

    public By dualCitizen = new By.ByCssSelector("#customerDualCitizenshipNo");

    public By residency = new By.ByCssSelector("#customerCountryOfResidence  option:nth-child(2)");

    public By dateOfBirth = new By.ByCssSelector("#customerBirthDate");

    public By saveAndConitue2= new By.ByCssSelector("#icaiContinueButton");

    //page 3
    public By employmentStatus = new By.ByCssSelector("#employmentStatus > option:nth-child(2)");

    public By occupation = new By.ByCssSelector("#occupation  option:nth-child(2)");

    public By annualIncome= new By.ByCssSelector("#annualSalary");

    public By sourceOfIncome = new By.ByCssSelector("#incomeSource  option:nth-child(2)");

    public By monthlyHousingPayment = new By.ByCssSelector("#monthlyHousingPayment");

    public By saveAndContinue3= new By.ByCssSelector("#icaiContinueButton");

    public By termsAndCondition = new By.ByCssSelector("#termsAndConditionsCheckBox");

    public By saveAndContinue4 = new By.ByCssSelector("#icaiContinueButton");

    public By reviewInfo = new By.ByCssSelector("#sectionHeader div h2");




}
