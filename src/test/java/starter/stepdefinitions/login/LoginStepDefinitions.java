package starter.stepdefinitions.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.Assert;
import starter.pages.DashboardPage;
import starter.pages.DemoLoginPage;
import starter.tasks.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinitions {

    @Given("{word} open the demo page")
    public void i_open_the_demo_page(String user) {
        givenThat(theActorCalled(user)).wasAbleTo(
                NavigateTo.theDemoLoginPage()
        );

    }
    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        when(theActorInTheSpotlight()).attemptsTo(
                Enter.theValue("username").into(DemoLoginPage.USERNAME_TEXTBOX),
                Enter.theValue("password").into(DemoLoginPage.PASSWORD_TEXTBOX),
                Click.on(DemoLoginPage.SIGN_IN_BUTTON)
        );
    }
    @Then("I log in successfully")
    public void i_log_in_successfully() {
        then(theActorInTheSpotlight()).attemptsTo(
                Ensure.that(DashboardPage.INITIAL_MESSAGE).isDisplayed()
        );
    }

}
