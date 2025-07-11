package co.com.udea.orangehrm.myinfo.tasks.personalinfo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import co.com.udea.orangehrm.myinfo.interactions.personalinfo.EnterPersonalData;
import co.com.udea.orangehrm.myinfo.interactions.personalinfo.ClickSaveButton;

public class UpdateEmployeeName implements Task {

    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final boolean shouldSave;

    public UpdateEmployeeName(String firstName, String middleName, String lastName, boolean shouldSave) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.shouldSave = shouldSave;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterPersonalData.withNames(firstName, middleName, lastName)
        );

        if (shouldSave) {
            actor.attemptsTo(ClickSaveButton.now());
        }
    }

    public static UpdateEmployeeName withCompleteData(String firstName, String middleName, String lastName) {
        return Tasks.instrumented(UpdateEmployeeName.class, firstName, middleName, lastName, true);
    }

    public static UpdateEmployeeName withoutSaving(String firstName, String middleName, String lastName) {
        return Tasks.instrumented(UpdateEmployeeName.class, firstName, middleName, lastName, false);
    }

    public static UpdateEmployeeName clearingFirstName() {
        return Tasks.instrumented(UpdateEmployeeName.class, "", null, null, false);
    }
}