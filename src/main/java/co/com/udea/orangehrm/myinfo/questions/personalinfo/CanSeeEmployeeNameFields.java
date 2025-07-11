package co.com.udea.orangehrm.myinfo.questions.personalinfo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.udea.orangehrm.myinfo.userinterfaces.PersonalDetailsPage.*;

public class CanSeeEmployeeNameFields implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(FIRST_NAME_INPUT).answeredBy(actor) &&
                Visibility.of(MIDDLE_NAME_INPUT).answeredBy(actor) &&
                Visibility.of(LAST_NAME_INPUT).answeredBy(actor);
    }

    public static CanSeeEmployeeNameFields correctly() {
        return new CanSeeEmployeeNameFields();
    }
}