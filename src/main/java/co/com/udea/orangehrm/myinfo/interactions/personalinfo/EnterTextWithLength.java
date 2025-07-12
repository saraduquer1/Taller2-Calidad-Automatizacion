package co.com.udea.orangehrm.myinfo.interactions.personalinfo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.udea.orangehrm.myinfo.userinterfaces.PersonalDetailsPage.*;

public class EnterTextWithLength implements Interaction {

    private final String fieldName;
    private final String text;

    public EnterTextWithLength(String fieldName, String text) {
        this.fieldName = fieldName;
        this.text = text;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (fieldName.toLowerCase()) {
            case "firstname":
                actor.attemptsTo(
                        Clear.field(FIRST_NAME_INPUT),
                        Enter.theValue(text).into(FIRST_NAME_INPUT)
                );
                break;
            case "middlename":
                actor.attemptsTo(
                        Clear.field(MIDDLE_NAME_INPUT),
                        Enter.theValue(text).into(MIDDLE_NAME_INPUT)
                );
                break;
            case "lastname":
                actor.attemptsTo(
                        Clear.field(LAST_NAME_INPUT),
                        Enter.theValue(text).into(LAST_NAME_INPUT)
                );
                break;
        }

        System.out.println("Escribiendo en " + fieldName + ": '" + text + "' (" + text.length() + " caracteres)");
    }

    public static EnterTextWithLength inField(String fieldName, String text) {
        return Tasks.instrumented(EnterTextWithLength.class, fieldName, text);
    }
}