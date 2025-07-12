package co.com.udea.orangehrm.myinfo.stepdefinitions.personalinfo;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.openqa.selenium.WebDriver;

import co.com.udea.orangehrm.myinfo.tasks.login.LoginToOrangeHRM;
import co.com.udea.orangehrm.myinfo.tasks.navigation.NavigateToMyInfo;
import co.com.udea.orangehrm.myinfo.tasks.personalinfo.AttemptToSave;
import co.com.udea.orangehrm.myinfo.tasks.personalinfo.TestFieldLengths;
import co.com.udea.orangehrm.myinfo.interactions.personalinfo.EnterPersonalData;
import co.com.udea.orangehrm.myinfo.questions.personalinfo.UpdateSuccessful;
import co.com.udea.orangehrm.myinfo.questions.personalinfo.FirstNameShowsError;
import co.com.udea.orangehrm.myinfo.questions.personalinfo.FieldLengthError;
import co.com.udea.orangehrm.myinfo.utils.Constants;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class PersonalDetailsValidationStepDefinition {

    private Actor empleado = Actor.named("Empleado");

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
        empleado.can(BrowseTheWeb.with(theDriver));
    }

    // ==================== BACKGROUND ====================

    @Given("el usuario se autentica en el sistema")
    public void elUsuarioSeAutenticaEnElSistema() {
        empleado.attemptsTo(LoginToOrangeHRM.withDefaultCredentials());
    }

    @And("navega a la sección My Info")
    public void navegaALaSeccionMyInfo() {
        empleado.attemptsTo(NavigateToMyInfo.page());
    }

    // ==================== FUNCIONALIDAD BÁSICA ====================

    @When("guarda los datos actuales sin modificar")
    public void guardaLosDatosActualesSinModificar() {
        empleado.attemptsTo(AttemptToSave.personalDetails());
    }

    @When("actualiza el nombre completo con First Name {string}, Middle Name {string} y Last Name {string}")
    public void actualizaElNombreCompletoConFirstNameMiddleNameYLastName(String firstName, String middleName, String lastName) {
        empleado.attemptsTo(EnterPersonalData.withNames(firstName, middleName, lastName));
    }

    @And("guarda los cambios")
    public void guardaLosCambios() {
        empleado.attemptsTo(AttemptToSave.personalDetails());
    }

    @Then("ve un mensaje de actualización exitosa")
    public void veUnMensajeDeActualizacionExitosa() {
        empleado.should(seeThat(UpdateSuccessful.message(), is(true)));
    }

    @When("borra completamente el campo First Name")
    public void borraCompletamenteElCampoFirstName() {
        empleado.attemptsTo(EnterPersonalData.clearFirstNameCompletely());
    }

    @And("intenta guardar los cambios")
    public void intentaGuardarLosCambios() {
        empleado.attemptsTo(AttemptToSave.personalDetailsExpectingValidation());
    }

    @Then("ve que el campo First Name muestra error de campo requerido")
    public void veQueElCampoFirstNameMuestraErrorDeCampoRequerido() {
        empleado.should(seeThat(FirstNameShowsError.correctly(), is(true)));
    }

    // ==================== VALIDACIONES DE LONGITUD ====================

    @When("ingresa texto de 31 caracteres en el campo {string}")
    public void ingresaTextoDe31CaracteresEnElCampo(String fieldName) {
        empleado.attemptsTo(TestFieldLengths.withText(fieldName, Constants.INVALID_31_CHARS));
    }

    @Then("debe ver mensaje de error de longitud en {string}")
    public void debeVerMensajeDeErrorDeLongitudEn(String fieldName) {
        empleado.should(seeThat(FieldLengthError.isVisibleFor(fieldName), is(true)));
    }
}