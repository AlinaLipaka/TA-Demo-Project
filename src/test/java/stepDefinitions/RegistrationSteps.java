package stepDefinitions;

import com.codeborne.selenide.Condition;
import helpers.YamlReader;
import io.cucumber.java.en.And;
import pages.RegistrationPage;

import java.time.Duration;

public class RegistrationSteps {

    private final YamlReader yamlReader = new YamlReader("test.yaml");

    @And("I fill in the Registration form")
    public void iFillInTheRegistrationForm() {
        RegistrationPage.socialTitleRadioMr.click();
        RegistrationPage.firstNameField.sendKeys(yamlReader.getName());
        RegistrationPage.lastNameField.sendKeys(yamlReader.getSurname());
        RegistrationPage.emailField.sendKeys(CommonSteps.generateNewUserEmail());
        RegistrationPage.passwordField.sendKeys(yamlReader.getPassword());
        RegistrationPage.termsAndConditionsCheckbox.click();
        RegistrationPage.dataPrivacyCheckbox.click();
    }

    @And("I save the Registration form")
    public void iSaveTheRegistrationForm() {
        RegistrationPage.saveFormButton.shouldBe(Condition.visible, Duration.ofSeconds(2)).click();
    }
}
