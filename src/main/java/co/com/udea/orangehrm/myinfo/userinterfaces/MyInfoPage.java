package co.com.udea.orangehrm.myinfo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class MyInfoPage extends PageObject {

    public static final Target MY_INFO_MENU = Target
            .the("Menú My Info en el sidebar")
            .locatedBy("//span[text()='My Info']");

    public static final Target MY_INFO_TITLE = Target
            .the("Título de la página My Info")
            .locatedBy("//h6[text()='Personal Details']");
}