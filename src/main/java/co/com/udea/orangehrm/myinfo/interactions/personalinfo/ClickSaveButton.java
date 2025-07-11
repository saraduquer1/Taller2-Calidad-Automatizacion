package co.com.udea.orangehrm.myinfo.interactions.personalinfo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.udea.orangehrm.myinfo.userinterfaces.PersonalDetailsPage.*;

public class ClickSaveButton implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("🔄 Clickeando botón Save (esperando éxito)...");

        if (Visibility.of(SAVE_BUTTON_ALT1).answeredBy(actor)) {
            actor.attemptsTo(Click.on(SAVE_BUTTON_ALT1));
            System.out.println("✅ Click ejecutado");

            // INMEDIATAMENTE buscar toast de éxito (CÓDIGO QUE FUNCIONABA)
            searchForToastImmediately(actor);

        } else {
            throw new RuntimeException("No se encontró botón Save");
        }
    }

    private void searchForToastImmediately(Actor actor) {
        try {
            System.out.println("🚀 Buscando toast INMEDIATAMENTE después del click...");

            for (int i = 0; i < 50; i++) { // 50 intentos x 100ms = 5 segundos
                Thread.sleep(100);

                if (Visibility.of(SUCCESS_TOAST).answeredBy(actor)) {
                    System.out.println("🎉 ¡TOAST encontrado en intento " + (i + 1) + "!");
                    actor.remember("toastFound", true);
                    return;
                }

                if (Visibility.of(SUCCESS_TOAST_MESSAGE).answeredBy(actor)) {
                    System.out.println("🎉 ¡MENSAJE encontrado en intento " + (i + 1) + "!");
                    actor.remember("toastFound", true);
                    return;
                }

                if (Visibility.of(SUCCESS_TOAST_TITLE).answeredBy(actor)) {
                    System.out.println("🎉 ¡TÍTULO encontrado en intento " + (i + 1) + "!");
                    actor.remember("toastFound", true);
                    return;
                }

                if (i % 10 == 0) {
                    System.out.println("🔍 Intento " + (i + 1) + "/50 - buscando toast...");
                }
            }

            System.out.println("❌ Toast no encontrado en 5 segundos");
            actor.remember("toastFound", false);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            actor.remember("toastFound", false);
        }
    }

    public static ClickSaveButton now() {
        return Tasks.instrumented(ClickSaveButton.class);
    }
}