package co.com.udea.orangehrm.myinfo.questions.personalinfo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.udea.orangehrm.myinfo.userinterfaces.PersonalDetailsPage.*;

public class FieldLengthError implements Question<Boolean> {

    private final String fieldName;

    public FieldLengthError(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            // Espera para que aparezca el error
            Thread.sleep(2000);

            boolean specificFieldError = false;
            boolean anyLengthError = false;

            // Verificar error específico del campo
            switch (fieldName.toLowerCase()) {
                case "firstname":
                    specificFieldError = Visibility.of(FIRST_NAME_LENGTH_ERROR).answeredBy(actor);
                    break;
                case "middlename":
                    specificFieldError = Visibility.of(MIDDLE_NAME_LENGTH_ERROR).answeredBy(actor);
                    break;
                case "lastname":
                    specificFieldError = Visibility.of(LAST_NAME_LENGTH_ERROR).answeredBy(actor);
                    break;
            }

            // Verificar si hay algún mensaje de longitud en la página
            anyLengthError = Visibility.of(LENGTH_ERROR_MESSAGE).answeredBy(actor);

            // Selector alternativo más genérico
            boolean genericError = actor.asksFor(Visibility.of(
                    Target.the("Error genérico de longitud")
                            .locatedBy("//span[text()='Should not exceed 30 characters']")
            ));

            boolean errorFound = specificFieldError || anyLengthError || genericError;

            if (errorFound) {
                System.out.println("✅ Mensaje de error de longitud detectado correctamente para " + fieldName);
            } else {
                System.out.println("❌ No se detectó mensaje de error de longitud para " + fieldName);
            }

            return errorFound;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public static FieldLengthError isVisibleFor(String fieldName) {
        return new FieldLengthError(fieldName);
    }
}