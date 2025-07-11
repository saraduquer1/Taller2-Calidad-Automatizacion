package co.com.udea.orangehrm.myinfo.interactions.navigation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.udea.orangehrm.myinfo.userinterfaces.MyInfoPage.MY_INFO_MENU;

public class ClickMyInfoMenu implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(MY_INFO_MENU));
    }

    public static ClickMyInfoMenu now() {
        return Tasks.instrumented(ClickMyInfoMenu.class);
    }
}