package co.com.udea.orangehrm.myinfo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {

    public static final Target USERNAME_INPUT = Target
            .the("Campo de usuario")
            .locatedBy("//input[@name='username']");

    public static final Target PASSWORD_INPUT = Target
            .the("Campo de contraseña")
            .locatedBy("//input[@name='password']");

    public static final Target LOGIN_BUTTON = Target
            .the("Botón de login")
            .locatedBy("//button[contains(@class,'orangehrm-login-button')]");
}