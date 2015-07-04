package org.fasttrackit.workshop.pagefactory.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(how = How.ID, using = "email")
    private WebElement emailEl;

    @FindBy(how = How.ID, using = "loginButton")
    private WebElement clicklog;

    @FindBy(how = How.ID, using = "email")
    private  WebElement email;

    @FindBy(how = How.ID, using = "password")
    private WebElement password;

    @FindBy(how = How.CLASS_NAME, using = "error-msg")
     private  WebElement error;




    public void enterEmail(String email) {
        emailEl.sendKeys(email);
    }

    public void clickOnLoginButton() {
        clicklog.click();
    }

    public void enterCredentials(String emailv, String passwordv) {

        email.sendKeys(emailv);
        password.sendKeys(passwordv);
    }


    public void errorMessageSouldbePresent( String expectedmessage ) {
     //  WebElement error = driver.findElement(By.className("error-msg"));
        //String expectedmessage = "Invalid user or password!";
        assertThat(error.getText(), is(expectedmessage));
}