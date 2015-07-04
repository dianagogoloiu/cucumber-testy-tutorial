package org.fasttrackit.workshop.Preferences;


import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PreferencesWindow {

    private WebLocator window = new WebLocator().setId("preferences-win");
    private WebLocator statusMessageEl = new WebLocator(window).setClasses("status-msg");

    private Button preferencesButton = new Button().setText("Preferences");

    private TextField currentpassword = new TextField(window).setLabel("Current Password");//.setContainer(window);

    private TextField newPassword = new TextField(window).setLabel("New Password");
    private TextField confirmNewPassword = new TextField(window).setLabel("Repeat Password");
    private Button saveButton = new Button(window).setText("Save");//.setContainer(window);
    private Button closeButton = new Button(window).setText("Close");//.setContainer(window);


    //.setLabelPosition("//following-sibling::*//input");
    //   private TextField currentpassword=new TextField().setElPath("//label[text()='Current Password']//following-sibling::*//input");


    //label[text()='Current Password']//following-sibling::*//input


    public static void main(String[] args) {


        PreferencesWindow preferencesWindow = new PreferencesWindow();
        System.out.println(preferencesWindow.saveButton.getPath());
        System.out.println(preferencesWindow.window.getPath());
        System.out.println(preferencesWindow.closeButton.getPath());
        System.out.println(preferencesWindow.statusMessageEl.getPath());

    }

    public void open() {
        preferencesButton.click();
        Utils.sleep(1000);//because of fading window


    }

    public void typeCurrentPassword(String password) {

        currentpassword.setValue(password);

    }

    public void typeNewPassword(String password) {

        newPassword.setValue(password);

    }

    public void typeConfirmPassword(String password) {
        confirmNewPassword.setValue(password);

    }

    public void save() {
        saveButton.assertClick();

    }


    public void statusMessageSouldbePresent(String expectedmessage) {
        //  WebElement error = driver.findElement(By.className("error-msg"));
        //String expectedmessage = "Invalid user or password!";
        assertThat(statusMessageEl.getHtmlText(), is(expectedmessage));
    }

    public void close() {
        closeButton.assertClick();
        Utils.sleep(1000);//because of fading window
    }
}