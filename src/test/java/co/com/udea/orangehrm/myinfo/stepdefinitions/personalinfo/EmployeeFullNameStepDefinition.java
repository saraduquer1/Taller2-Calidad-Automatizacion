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
import co.com.udea.orangehrm.myinfo.interactions.personalinfo.EnterPersonalData;
import co.com.udea.orangehrm.myinfo.questions.personalinfo.UpdateSuccessful;
import co.com.udea.orangehrm.myinfo.questions.personalinfo.FirstNameShowsError;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class EmployeeFullNameStepDefinition {

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

    // ==================== ESCENARIO 1: Guardar sin cambios ====================

    @When("guarda los datos actuales sin modificar")
    public void guardaLosDatosActualesSinModificar() {
        empleado.attemptsTo(AttemptToSave.personalDetails());
    }

    // ==================== ESCENARIO 2: Actualización exitosa ====================

    @When("borra el contenido actual del First Name")
    public void borraElContenidoActualDelFirstName() {
        // Este paso se manejará junto con el siguiente
    }

    @And("actualiza su First Name a {string}")
    public void actualizaSuFirstNameA(String firstName) {
        empleado.attemptsTo(EnterPersonalData.withFirstName(firstName));
    }

    @And("borra el contenido actual del Last Name")
    public void borraElContenidoActualDelLastName() {
        // Este paso se manejará junto con el siguiente
    }

    @And("actualiza su Last Name a {string}")
    public void actualizaSuLastNameA(String lastName) {
        empleado.attemptsTo(EnterPersonalData.withLastName(lastName));
    }

    @And("borra el contenido actual del Middle Name")
    public void borraElContenidoActualDelMiddleName() {
        // Este paso se manejará junto con el siguiente
    }

    @And("actualiza su Middle Name a {string}")
    public void actualizaSuMiddleNameA(String middleName) {
        empleado.attemptsTo(EnterPersonalData.withMiddleName(middleName));
    }

    @And("guarda los cambios")
    public void guardaLosCambios() {
        empleado.attemptsTo(AttemptToSave.personalDetails());
    }

    // ==================== THEN COMPARTIDO PARA ESCENARIO 1 Y 2 ====================

    @Then("ve un mensaje de actualización exitosa")
    public void veUnMensajeDeActualizacionExitosa() {
        empleado.should(seeThat(UpdateSuccessful.message(), is(true)));
    }

    // ==================== ESCENARIO 3: Validación ====================

    @When("borra completamente el campo First Name")
    public void borraCompletamenteElCampoFirstName() {
        empleado.attemptsTo(EnterPersonalData.clearFirstNameCompletely());
    }

    @And("intenta guardar los cambios")
    public void intentaGuardarLosCambios() {
        empleado.attemptsTo(AttemptToSave.personalDetailsExpectingValidation()); // ← CAMBIO AQUÍ
    }

    @Then("ve que el campo First Name muestra error de campo requerido")
    public void veQueElCampoFirstNameMuestraErrorDeCampoRequerido() {
        empleado.should(seeThat(FirstNameShowsError.correctly(), is(true)));
    }
}