package org.fasttrackit.workshop.login;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.workshop.Preferences.PreferencesWindow;

public class PreferencesSteps extends TestBase{

    public static final String NEW_PASSWORD = "eu.p";
    private PreferencesWindow preferencesWindow= new PreferencesWindow();



    @When("^I click on Preferences button$")
    public void I_click_on_Preferences_button() {

        preferencesWindow.open();

    }

    @And("^I input Current Password$")
    public void I_input_Current_Password()  {

        preferencesWindow.typeCurrentPassword(LoginSteps.VALID_PASSWORD);
    }

    @And("^I input New Password$")
    public void I_input_New_Password()  {
preferencesWindow.typeNewPassword(NEW_PASSWORD);


    }

    @And("^I confirm the New Password$")
    public void I_confirm_the_New_Password() {
preferencesWindow.typeConfirmPassword(NEW_PASSWORD);
    }

    @And("^I click on Save button$")
    public void I_click_on_Save_button() {
        preferencesWindow.open();
    }

    @Then("^I should see \"([^\"]*)\" message.$")
    public void I_should_see_message(String arg1)  {

    }

    @And("^I close the Preferences window.$")
    public void I_close_the_Preferences_window()  {

    }

    @Then("^I can re-login with new credentials$")
    public void I_can_re_login_with_new_credentials()  {

    }
}
