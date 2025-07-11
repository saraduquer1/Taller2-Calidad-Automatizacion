package co.com.udea.orangehrm.myinfo.interactions.personalinfo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

import static co.com.udea.orangehrm.myinfo.userinterfaces.PersonalDetailsPage.*;

public class EnterPersonalData implements Interaction {

    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final boolean clearFirst;
    private final boolean clearMiddle;
    private final boolean clearLast;

    public EnterPersonalData(String firstName, String middleName, String lastName,
                             boolean clearFirst, boolean clearMiddle, boolean clearLast) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.clearFirst = clearFirst;
        this.clearMiddle = clearMiddle;
        this.clearLast = clearLast;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        ClearInput(actor, clearFirst, FIRST_NAME_INPUT, firstName);

        ClearInput(actor, clearMiddle, MIDDLE_NAME_INPUT, middleName);

        ClearInput(actor, clearLast, LAST_NAME_INPUT, lastName);
    }

    public <T extends Actor> void ClearInput(T actor, boolean clearLast, Target lastNameInput, String lastName) {
        if (clearLast) {
            actor.attemptsTo(
                    Clear.field(lastNameInput),
                    SendKeys.of(Keys.CONTROL + "a").into(lastNameInput),
                    SendKeys.of(Keys.DELETE).into(lastNameInput)
            );
        }

        if (lastName != null && !lastName.isEmpty()) {
            if (!clearLast) {
                actor.attemptsTo(Clear.field(lastNameInput));
            }
            actor.attemptsTo(Enter.theValue(lastName).into(lastNameInput));
        }
    }

    public static EnterPersonalData withNames(String firstName, String middleName, String lastName) {
        return Tasks.instrumented(EnterPersonalData.class, firstName, middleName, lastName, true, true, true);
    }

    public static EnterPersonalData withFirstName(String firstName) {
        return Tasks.instrumented(EnterPersonalData.class, firstName, null, null, true, false, false);
    }

    public static EnterPersonalData withLastName(String lastName) {
        return Tasks.instrumented(EnterPersonalData.class, null, null, lastName, false, false, true);
    }

    public static EnterPersonalData withMiddleName(String middleName) {
        return Tasks.instrumented(EnterPersonalData.class, null, middleName, null, false, true, false);
    }

    public static EnterPersonalData clearFirstNameCompletely() {
        return Tasks.instrumented(EnterPersonalData.class, "", null, null, true, false, false);
    }

    public static EnterPersonalData clearAllFields() {
        return Tasks.instrumented(EnterPersonalData.class, "", "", "", true, true, true);
    }
}