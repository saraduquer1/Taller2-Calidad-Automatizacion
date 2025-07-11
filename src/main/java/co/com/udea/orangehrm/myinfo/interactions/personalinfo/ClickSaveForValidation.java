package co.com.udea.orangehrm.myinfo.interactions.personalinfo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.udea.orangehrm.myinfo.userinterfaces.PersonalDetailsPage.*;

public class ClickSaveForValidation implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Click en botón Save ...");

        if (Visibility.of(SAVE_BUTTON).answeredBy(actor)) {
            actor.attemptsTo(Click.on(SAVE_BUTTON));
            System.out.println("Click ejecutado - NO debería pasar nada (datos inválidos)");

            // Para validación NO buscamos toast, solo hacemos click

        } else {
            throw new RuntimeException("No se encontró botón Save");
        }
    }

    public static ClickSaveForValidation now() {
        return Tasks.instrumented(ClickSaveForValidation.class);
    }
}