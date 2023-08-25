package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DemoLoginPage extends PageObject {

    public static final Target USERNAME_TEXTBOX = Target.the("Username textbox").located(By.id("username"));
    public static final Target PASSWORD_TEXTBOX = Target.the("Password textbox").located(By.id("password"));
    public static final Target SIGN_IN_BUTTON = Target.the("Sign In button").located(By.id("log-in"));
}
