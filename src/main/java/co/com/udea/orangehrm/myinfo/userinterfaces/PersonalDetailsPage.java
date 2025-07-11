package co.com.udea.orangehrm.myinfo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PersonalDetailsPage extends PageObject {

    // Campos de Employee Full Name
    public static final Target FIRST_NAME_INPUT = Target
            .the("Campo First Name")
            .locatedBy("//input[contains(@class,'orangehrm-firstname')]");

    public static final Target MIDDLE_NAME_INPUT = Target
            .the("Campo Middle Name")
            .locatedBy("//input[contains(@class,'orangehrm-middlename')]");

    public static final Target LAST_NAME_INPUT = Target
            .the("Campo Last Name")
            .locatedBy("//input[contains(@class,'orangehrm-lastname')]");

    // Botón Save específico (el primero que tiene ambos data-v)
    public static final Target SAVE_BUTTON = Target
            .the("Botón Save de Employee Details")
            .locatedBy("//button[@data-v-6653c066 and contains(@class,'orangehrm-left-space')]");

    // Alternativa por posición
    public static final Target SAVE_BUTTON_ALT1 = Target
            .the("Primer botón Save")
            .locatedBy("(//button[@type='submit' and contains(@class,'orangehrm-left-space')])[1]");

    // Alternativa más simple
    public static final Target SAVE_BUTTON_ALT2 = Target
            .the("Cualquier botón Save")
            .locatedBy("//button[@type='submit' and contains(text(),'Save')]");

    // Alternativa súper simple
    public static final Target SAVE_BUTTON_ALT3 = Target
            .the("Botón con texto Save")
            .locatedBy("//button[contains(text(),'Save')]");


    // Loader y mensajes con selectores exactos
    public static final Target LOADER_SPINNER = Target
            .the("Ruedita de carga")
            .locatedBy("//div[contains(@class,'oxd-loading-spinner')]");

    public static final Target SUCCESS_TOAST = Target
            .the("Toast de éxito")
            .locatedBy("//div[contains(@class,'oxd-toast--success')]");

    public static final Target SUCCESS_TOAST_MESSAGE = Target
            .the("Mensaje Successfully Updated")
            .locatedBy("//p[text()='Successfully Updated']");

    public static final Target SUCCESS_TOAST_TITLE = Target
            .the("Título Success")
            .locatedBy("//p[text()='Success']");

    public static final Target REQUIRED_ERROR = Target
            .the("Mensaje de error Required")
            .locatedBy("//span[text()='Required']");

    // Para verificar que los campos están en rojo cuando hay error
    public static final Target FIRST_NAME_ERROR = Target
            .the("Campo First Name con error")
            .locatedBy("//input[contains(@class,'orangehrm-firstname') and contains(@class,'oxd-input--error')]");

    public static final Target LAST_NAME_ERROR = Target
            .the("Campo Last Name con error")
            .locatedBy("//input[contains(@class,'orangehrm-lastname') and contains(@class,'oxd-input--error')]");
}