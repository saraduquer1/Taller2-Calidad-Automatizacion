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

    // Error States - SELECTORES MEJORADOS
    public static final Target REQUIRED_ERROR = Target
            .the("Mensaje de error Required")
            .locatedBy("//span[contains(@class,'oxd-text') and contains(@class,'oxd-input-field-error-message') and text()='Required']");

    public static final Target FIRST_NAME_ERROR = Target
            .the("Error en el campo First Name")
            .locatedBy("//input[contains(@class,'orangehrm-firstname')]/parent::div//span[contains(@class,'oxd-input-field-error-message')]");

    public static final Target LAST_NAME_ERROR = Target
            .the("Error en el campo Last Name")
            .locatedBy("//input[contains(@class,'orangehrm-lastname')]/parent::div//span[contains(@class,'oxd-input-field-error-message')]");

    // ==================== NUEVOS SELECTORES PARA VALIDACIONES DE LONGITUD ====================

    // Mensajes de error de longitud máxima - SELECTORES MEJORADOS
    public static final Target LENGTH_ERROR_MESSAGE = Target
            .the("Mensaje de error de longitud")
            .locatedBy("//span[contains(@class,'oxd-input-field-error-message') and text()='Should not exceed 30 characters']");

    // Mensajes de error específicos por campo (más genéricos)
    public static final Target FIRST_NAME_LENGTH_ERROR = Target
            .the("Error de longitud en First Name")
            .locatedBy("//input[contains(@class,'orangehrm-firstname')]/parent::div//span[contains(@class,'oxd-input-field-error-message')]");

    public static final Target MIDDLE_NAME_LENGTH_ERROR = Target
            .the("Error de longitud en Middle Name")
            .locatedBy("//input[contains(@class,'orangehrm-middlename')]/parent::div//span[contains(@class,'oxd-input-field-error-message')]");

    public static final Target LAST_NAME_LENGTH_ERROR = Target
            .the("Error de longitud en Last Name")
            .locatedBy("//input[contains(@class,'orangehrm-lastname')]/parent::div//span[contains(@class,'oxd-input-field-error-message')]");
}