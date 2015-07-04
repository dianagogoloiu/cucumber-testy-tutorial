package org.fasttrackit.workshop.login;

import com.sdl.selenium.web.utils.Utils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.workshop.pagefactory.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);
    public static final String VALID_EMAIL = "eu@fast.com";
    public static  String VALID_PASSWORD = "eu.pass";
    private LoginView loginPage=new LoginView();

   /// LoginPage loginPage=new LoginPage();

  //  public LoginSteps() {

    //    initPage();
//
  //  }

 //   public void initPage() {
  //      loginPage = PageFactory.initElements(driver, LoginPage.class);
  //  }



    @Given("^I access the login page$")
    public void I_access_the_login_page() throws Throwable {
     driver.get("https://dl.dropboxusercontent.com/u/16174618/FastTrackIT/app-demo/login.html");
    //    driver.get("file:///C:/Users/dianag/Desktop/installers/app-demo/login.html");
    }

    @Given("^I insert valid credentials$")
    public void I_insert_valid_credentials() throws Throwable {
    WebElement email = driver.findElement(By.id("email"));
    //    email.sendKeys("eu@fast.com");
//
        WebElement password=driver.findElement(By.id("password"));
      //  password.sendKeys("eu.pass");
I_enter_credentials(VALID_EMAIL, VALID_PASSWORD);
    }

    @When("^I click login button$")
    public void I_click_login_button() throws Throwable {
        loginPage.clickOnLoginButton();

     }



    @Then("^I check if user was logged in$")
    public void I_check_if_user_was_logged_in() throws Throwable {
        boolean succeslogin =false;

        try{
            WebElement logout = driver.findElement(By.linkText("Logout"));
            succeslogin=logout.isDisplayed();
        }
      catch(Exception e)
      {

      }
        assertThat("could not found the logout button", succeslogin, is(true));



        //  WebElement logout = driver.findElement(By.linkText("Logout"));
      // boolean succeslogin = logout.isDisplayed();
       // assertThat("could not found the logout button", succeslogin, is(true));


    }


    @Given("^I insert invalid credentials$")
    public void I_insert_invalid_credentials() throws Throwable {

       // WebElement email = driver.findElement(By.id("email"));
       // email.sendKeys("aa@fast.com");

      //  WebElement password=driver.findElement(By.id("password"));
       // password.sendKeys("aa.pass");
        I_enter_credentials("ea@fast.com","ea.pass");




    }

    @Then("^I expect invalid credential message$")
    public void I_expect_invalid_credential_message() throws Throwable {
        loginPage.errorMessageSouldbePresent("Invalid user or password!");

     //   Utils.sleep(1000);
    }




    @When("^I enter \"([^\"]*)\"/\"([^\"]*)\" credentials$")
    public void I_enter_credentials(String emailv, String passwordv) throws Throwable {


        loginPage.enterCredentials(emailv, passwordv);

    }


    @Then("^I expect \"([^\"]*)\"error message$")
    public void I_expect_error_message(String expectedmessage) throws Throwable {

        loginPage.errorMessageSouldbePresent(expectedmessage);

    }

    @Given("^I successfully login$")
    public void I_successfully_login() throws Throwable {
        I_access_the_login_page();
        I_insert_valid_credentials();
        I_click_login_button();
        I_check_if_user_was_logged_in();

    }


//
  //  @Given("^I open this url \"([^\"]*)\"$")
   // public void I_open_this_url(String url) throws Throwable {
  //   driver.get(url);
   // }

   // @Then("^I send (\\d+) into  search field$")
  //  public void I_send_into_search_field(int arg1) throws Throwable {
  //      System.out.println("numarul este" + arg1);
  //  }




}
