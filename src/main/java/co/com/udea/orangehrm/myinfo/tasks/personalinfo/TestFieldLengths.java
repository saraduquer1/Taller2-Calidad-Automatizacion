package co.com.udea.orangehrm.myinfo.tasks.personalinfo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import co.com.udea.orangehrm.myinfo.interactions.personalinfo.EnterTextWithLength;

public class TestFieldLengths implements Task {

    private final String fieldName;
    private final String textToEnter;

    public TestFieldLengths(String fieldName, String textToEnter) {
        this.fieldName = fieldName;
        this.textToEnter = textToEnter;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterTextWithLength.inField(fieldName, textToEnter)
        );
    }

    public static TestFieldLengths withText(String fieldName, String text) {
        return Tasks.instrumented(TestFieldLengths.class, fieldName, text);
    }
}