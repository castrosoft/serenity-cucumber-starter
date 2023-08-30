package starter.stepdefinitions.login;

import io.cucumber.java.af.En;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starter.helpers.JsonReader;
import starter.pages.DashboardPage;
import starter.pages.DemoLoginPage;
import starter.tasks.EnterCredentials;
import starter.tasks.NavigateTo;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinitions {

    private static final Map<String, String> LOGIN_DATA = JsonReader.getDataFrom("src/test/resources/testdata/users.json");
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginStepDefinitions.class);

    @Given("{word} open the demo page")
    public void i_open_the_demo_page(String user) {
        LOGGER.info("Accessing to the NavigateTo task with the user: {}", user);
        givenThat(theActorCalled(user)).wasAbleTo(
                NavigateTo.theDemoLoginPage()
        );

    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        when(theActorInTheSpotlight()).attemptsTo(
                EnterCredentials.withUsername(LOGIN_DATA.get("username")).andPassword(LOGIN_DATA.get("password"))
        );
    }

    @Then("The log in is successfully")
    public void the_log_in_is_successfully() {
        then(theActorInTheSpotlight()).attemptsTo(
                Ensure.that(DemoLoginPage.SIGN_IN_BUTTON).isNotDisplayed()
        );
    }

}
