package co.com.udea.orangehrm.myinfo.questions.navigation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static co.com.udea.orangehrm.myinfo.userinterfaces.MyInfoPage.MY_INFO_TITLE;

public class IsOnMyInfoPage implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(MY_INFO_TITLE).answeredBy(actor);
    }

    public static IsOnMyInfoPage successfully() {
        return new IsOnMyInfoPage();
    }
}