package co.com.udea.orangehrm.myinfo.questions.personalinfo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.udea.orangehrm.myinfo.userinterfaces.PersonalDetailsPage.*;

public class FirstNameShowsError implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            // Pequeña espera para que aparezcan los errores después del click
            Thread.sleep(1000);

            boolean fieldHasError = Visibility.of(FIRST_NAME_ERROR).answeredBy(actor);
            boolean requiredMessageVisible = Visibility.of(REQUIRED_ERROR).answeredBy(actor);

            // Debug: imprimir resultados
            System.out.println("🔍 FIRST_NAME_ERROR visible: " + fieldHasError);
            System.out.println("🔍 REQUIRED_ERROR visible: " + requiredMessageVisible);

            return fieldHasError || requiredMessageVisible;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public static FirstNameShowsError correctly() {
        return new FirstNameShowsError();
    }
}