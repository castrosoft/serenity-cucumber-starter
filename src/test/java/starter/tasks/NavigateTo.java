package starter.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import starter.pages.DemoLoginPage;
import starter.pages.DuckDuckGoHomePage;

public class NavigateTo {
    public static Performable theSearchHomePage() {
        return Task.where("{0} opens the DuckDuckGo home page",
                Open.browserOn().the(DuckDuckGoHomePage.class));
    }

    public static Performable theDemoLoginPage() {
        return Task.where("{0} opens the Demo login page",
                Open.browserOn().the(DemoLoginPage.class));
    }
}
