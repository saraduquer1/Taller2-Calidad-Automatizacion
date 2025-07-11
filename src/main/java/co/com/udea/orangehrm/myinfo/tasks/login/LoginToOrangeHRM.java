package co.com.udea.orangehrm.myinfo.tasks.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;

import co.com.udea.orangehrm.myinfo.utils.Constants;
import static co.com.udea.orangehrm.myinfo.userinterfaces.LoginPage.*;

public class LoginToOrangeHRM implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(Constants.BASE_URL),
                Enter.theValue(Constants.USERNAME).into(USERNAME_INPUT),
                Enter.theValue(Constants.PASSWORD).into(PASSWORD_INPUT),
                Click.on(LOGIN_BUTTON)
        );
    }

    public static LoginToOrangeHRM withDefaultCredentials() {
        return Tasks.instrumented(LoginToOrangeHRM.class);
    }
}