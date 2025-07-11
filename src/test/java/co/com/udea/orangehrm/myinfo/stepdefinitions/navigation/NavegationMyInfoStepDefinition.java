package co.com.udea.orangehrm.myinfo.stepdefinitions.navigation;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.openqa.selenium.WebDriver;

import co.com.udea.orangehrm.myinfo.tasks.login.LoginToOrangeHRM;
import co.com.udea.orangehrm.myinfo.tasks.navigation.NavigateToMyInfo;
import co.com.udea.orangehrm.myinfo.questions.navigation.IsOnMyInfoPage;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class NavegationMyInfoStepDefinition {

    private Actor usuario = Actor.named("Usuario");

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(theDriver));
    }

    @Given("el usuario se autentica en el sistema")
    public void elUsuarioSeAutenticaEnElSistema() {
        usuario.attemptsTo(LoginToOrangeHRM.withDefaultCredentials());
    }

    @When("navega a la sección My Info")
    public void navegaALaSeccionMyInfo() {
        usuario.attemptsTo(NavigateToMyInfo.page());
    }

    @Then("puede ver la página de información personal")
    public void puedeVerLaPaginaDeInformacionPersonal() {
        usuario.should(seeThat(IsOnMyInfoPage.successfully(), is(true)));
    }
}