package org.fasttrackit.workshop.login;

import com.sdl.selenium.web.WebLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginView {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginView.class);

    @FindBy(how = How.ID, using = "email")
    private WebElement emailEl;


    private WebLocator clicklog= new WebLocator().setId("loginButton");


    private WebLocator email= new WebLocator().setId("email");


    private WebLocator password= new WebLocator().setId("password");

    private WebLocator error=new WebLocator().setClasses("error-msg");


    public void enterEmail(String email) {
        emailEl.sendKeys(email);
    }

    public void clickOnLoginButton() {
        clicklog.click();
    }

    public void enterCredentials(String emailv, String passwordv) {
        System.out.println("enter email" + emailv);
        email.sendKeys(emailv);
        System.out.println("enter password" + passwordv);
        password.sendKeys(passwordv);
    }


    public void errorMessageSouldbePresent(String expectedmessage) {
        //  WebElement error = driver.findElement(By.className("error-msg"));
        //String expectedmessage = "Invalid user or password!";
        assertThat(error.getHtmlText(), is(expectedmessage));

    }
}