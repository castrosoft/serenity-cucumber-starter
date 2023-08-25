package starter.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage {
    public static final Target INITIAL_MESSAGE = Target.the("Initial message").located(By.id("time"));
}
