package starter.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.pages.DemoLoginPage;

public class EnterCredentials {
    public static Performable toTheFields() {
        return Task.where("{0} enter credentials to the fields",
                Enter.theValue("username").into(DemoLoginPage.USERNAME_TEXTBOX),
                Enter.theValue("password").into(DemoLoginPage.PASSWORD_TEXTBOX),
                Click.on(DemoLoginPage.SIGN_IN_BUTTON)
        );
    }
}
