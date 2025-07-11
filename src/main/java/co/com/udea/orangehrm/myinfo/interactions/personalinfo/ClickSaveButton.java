package co.com.udea.orangehrm.myinfo.interactions.personalinfo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Arrays;
import java.util.List;

import static co.com.udea.orangehrm.myinfo.userinterfaces.PersonalDetailsPage.*;
import static co.com.udea.orangehrm.myinfo.utils.Constants.*;

public class ClickSaveButton implements Interaction {

    private static final List<Target> TOAST_ELEMENTS = Arrays.asList(
            SUCCESS_TOAST,
            SUCCESS_TOAST_MESSAGE,
            SUCCESS_TOAST_TITLE
    );

    @Override
    public <T extends Actor> void performAs(T actor) {
        logAction("Click en botón Save ...");

        if (!isButtonVisible(actor)) {
            throw new RuntimeException("No se encontró botón Save");
        }

        clickSaveButton(actor);
        searchForSuccessToast(actor);
    }

    private boolean isButtonVisible(Actor actor) {
        return Visibility.of(SAVE_BUTTON).answeredBy(actor);
    }

    private void clickSaveButton(Actor actor) {
        actor.attemptsTo(Click.on(SAVE_BUTTON));
        logAction("Click ejecutado");
    }

    private void searchForSuccessToast(Actor actor) {
        logAction("Buscando toast INMEDIATAMENTE después del click...");

        boolean toastFound = waitForToast(actor);
        actor.remember(TOAST_FOUND_KEY, toastFound);

        if (toastFound) {
            logAction("¡Toast detectado exitosamente!");
        } else {
            logAction("Toast no encontrado en " + TOAST_TOTAL_TIMEOUT.getSeconds() + " segundos");
        }
    }

    private boolean waitForToast(Actor actor) {
        for (int attempt = 1; attempt <= TOAST_MAX_ATTEMPTS; attempt++) {
            if (isAnyToastVisible(actor)) {
                logAction(String.format("¡Toast encontrado en intento %d!", attempt));
                return true;
            }

            sleepBetweenAttempts();
            logProgressIfNeeded(attempt);
        }
        return false;
    }

    private boolean isAnyToastVisible(Actor actor) {
        return TOAST_ELEMENTS.stream()
                .anyMatch(element -> Visibility.of(element).answeredBy(actor));
    }

    private void sleepBetweenAttempts() {
        try {
            Thread.sleep(TOAST_WAIT_BETWEEN_ATTEMPTS.toMillis());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Búsqueda de toast interrumpida", e);
        }
    }

    private void logProgressIfNeeded(int attempt) {
        if (attempt % 10 == 0) {
            logAction(String.format("Intento %d/%d - buscando toast...", attempt, TOAST_MAX_ATTEMPTS));
        }
    }

    private void logAction(String message) {
        System.out.println(message);
    }

    public static ClickSaveButton now() {
        return Tasks.instrumented(ClickSaveButton.class);
    }
}