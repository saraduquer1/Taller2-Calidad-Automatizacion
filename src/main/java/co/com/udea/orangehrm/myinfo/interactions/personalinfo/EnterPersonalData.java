package co.com.udea.orangehrm.myinfo.interactions.personalinfo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
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
        if (clearFirst) {
            actor.attemptsTo(
                    Clear.field(FIRST_NAME_INPUT),
                    SendKeys.of(Keys.CONTROL + "a").into(FIRST_NAME_INPUT),
                    SendKeys.of(Keys.DELETE).into(FIRST_NAME_INPUT)
            );
        }

        if (firstName != null && !firstName.isEmpty()) {
            if (!clearFirst) {
                actor.attemptsTo(Clear.field(FIRST_NAME_INPUT));
            }
            actor.attemptsTo(Enter.theValue(firstName).into(FIRST_NAME_INPUT));
        }

        if (clearMiddle) {
            actor.attemptsTo(
                    Clear.field(MIDDLE_NAME_INPUT),
                    SendKeys.of(Keys.CONTROL + "a").into(MIDDLE_NAME_INPUT),
                    SendKeys.of(Keys.DELETE).into(MIDDLE_NAME_INPUT)
            );
        }

        if (middleName != null && !middleName.isEmpty()) {
            if (!clearMiddle) {
                actor.attemptsTo(Clear.field(MIDDLE_NAME_INPUT));
            }
            actor.attemptsTo(Enter.theValue(middleName).into(MIDDLE_NAME_INPUT));
        }

        if (clearLast) {
            actor.attemptsTo(
                    Clear.field(LAST_NAME_INPUT),
                    SendKeys.of(Keys.CONTROL + "a").into(LAST_NAME_INPUT),
                    SendKeys.of(Keys.DELETE).into(LAST_NAME_INPUT)
            );
        }

        if (lastName != null && !lastName.isEmpty()) {
            if (!clearLast) {
                actor.attemptsTo(Clear.field(LAST_NAME_INPUT));
            }
            actor.attemptsTo(Enter.theValue(lastName).into(LAST_NAME_INPUT));
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