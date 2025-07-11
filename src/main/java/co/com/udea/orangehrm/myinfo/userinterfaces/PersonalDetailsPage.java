package co.com.udea.orangehrm.myinfo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PersonalDetailsPage extends PageObject {

    // Employee Name Fields
    public static final Target FIRST_NAME_INPUT = Target
            .the("Campo First Name")
            .locatedBy("//input[contains(@class,'orangehrm-firstname')]");

    public static final Target MIDDLE_NAME_INPUT = Target
            .the("Campo Middle Name")
            .locatedBy("//input[contains(@class,'orangehrm-middlename')]");

    public static final Target LAST_NAME_INPUT = Target
            .the("Campo Last Name")
            .locatedBy("//input[contains(@class,'orangehrm-lastname')]");

    // Save Button - usando el selector más confiable
    public static final Target SAVE_BUTTON = Target
            .the("Primer botón Save")
            .locatedBy("(//button[@type='submit' and contains(@class,'orangehrm-left-space')])[1]");

    // Loading State
    public static final Target LOADER_SPINNER = Target
            .the("Ruedita de carga")
            .locatedBy("//div[contains(@class,'oxd-loading-spinner')]");

    // Success Notifications
    public static final Target SUCCESS_TOAST = Target
            .the("Toast de éxito")
            .locatedBy("//div[contains(@class,'oxd-toast--success')]");

    public static final Target SUCCESS_TOAST_MESSAGE = Target
            .the("Mensaje Successfully Updated")
            .locatedBy("//p[text()='Successfully Updated']");

    public static final Target SUCCESS_TOAST_TITLE = Target
            .the("Título Success")
            .locatedBy("//p[text()='Success']");

    // Error States
    public static final Target REQUIRED_ERROR = Target
            .the("Mensaje de error Required")
            .locatedBy("//span[text()='Required']");

    public static final Target FIRST_NAME_ERROR = Target
            .the("Campo First Name con error")
            .locatedBy("//input[contains(@class,'orangehrm-firstname') and contains(@class,'oxd-input--error')]");

    public static final Target LAST_NAME_ERROR = Target
            .the("Campo Last Name con error")
            .locatedBy("//input[contains(@class,'orangehrm-lastname') and contains(@class,'oxd-input--error')]");
}