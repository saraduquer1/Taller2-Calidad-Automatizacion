package co.com.udea.orangehrm.myinfo.tasks.navigation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import co.com.udea.orangehrm.myinfo.interactions.navigation.ClickMyInfoMenu;

public class NavigateToMyInfo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickMyInfoMenu.now()
        );
    }

    public static NavigateToMyInfo page() {
        return Tasks.instrumented(NavigateToMyInfo.class);
    }
}