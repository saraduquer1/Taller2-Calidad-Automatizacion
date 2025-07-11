package co.com.udea.orangehrm.myinfo.questions.personalinfo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class UpdateSuccessful implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        // Solo verificar si ClickSaveButton encontró el toast
        Boolean toastFound = actor.recall("toastFound");

        if (toastFound != null && toastFound) {
            System.out.println("✅ Toast fue detectado durante la operación de Save!");
            return true;
        } else {
            System.out.println("❌ Toast no fue detectado durante la operación de Save");
            return false;
        }
    }

    public static UpdateSuccessful message() {
        return new UpdateSuccessful();
    }
}