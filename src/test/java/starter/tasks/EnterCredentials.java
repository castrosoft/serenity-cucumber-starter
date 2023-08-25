package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.pages.DemoLoginPage;

public class EnterCredentials implements Task {

    private final String username;
    private final String password;

    public EnterCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginBuilder withUsername(String username) {
        return new LoginBuilder(username);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(DemoLoginPage.USERNAME_TEXTBOX),
                Enter.theValue(password).into(DemoLoginPage.PASSWORD_TEXTBOX),
                Click.on(DemoLoginPage.SIGN_IN_BUTTON)
        );
    }

    public static class LoginBuilder {
        private final String username;

        public LoginBuilder(String username) {
            this.username = username;
        }

        public Performable andPassword(String password) {
            return new EnterCredentials(username, password);
        }
    }
}
