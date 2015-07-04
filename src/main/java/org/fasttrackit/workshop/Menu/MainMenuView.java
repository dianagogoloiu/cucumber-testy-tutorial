package org.fasttrackit.workshop.Menu;

import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.link.WebLink;

public class MainMenuView {

    public static Button preferencesButton = new Button().setText("Preferences");
    public static WebLink logoutLink = new WebLink().setText("Logout");

public static void logout()
{
    logoutLink.assertClick();

}


}

