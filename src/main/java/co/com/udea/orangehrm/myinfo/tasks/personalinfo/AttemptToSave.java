package co.com.udea.orangehrm.myinfo.tasks.personalinfo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import co.com.udea.orangehrm.myinfo.interactions.personalinfo.ClickSaveButton;
import co.com.udea.orangehrm.myinfo.interactions.personalinfo.ClickSaveForValidation;

public class AttemptToSave implements Task {

    private final boolean expectingSuccess;

    public AttemptToSave(boolean expectingSuccess) {
        this.expectingSuccess = expectingSuccess;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (expectingSuccess) {
            // Para casos de éxito 1 y 2 - busca toast
            actor.attemptsTo(ClickSaveButton.now());
        } else {
            // Para casos de validación 3 - NO busca toast
            actor.attemptsTo(ClickSaveForValidation.now());
        }
    }

    public static AttemptToSave personalDetails() {
        return Tasks.instrumented(AttemptToSave.class, true); // Por defecto espera éxito
    }

    public static AttemptToSave personalDetailsExpectingValidation() {
        return Tasks.instrumented(AttemptToSave.class, false); // Espera validación
    }
}