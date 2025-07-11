package co.com.udea.orangehrm.myinfo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/EmployeeFullName.feature",
        glue = "co.com.udea.orangehrm.myinfo.stepdefinitions.personalinfo",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class EmployeeFullNameRunner {
}