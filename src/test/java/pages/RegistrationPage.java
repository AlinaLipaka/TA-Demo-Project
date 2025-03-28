package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public static final SelenideElement socialTitleRadioMr = $(byId("field-id_gender-1"));
    public static final SelenideElement socialTitleRadioMrs = $(byId("field-id_gender-2"));
    public static final SelenideElement firstNameField = $(byId("field-firstname"));
    public static final SelenideElement lastNameField = $(byId("field-lastname"));
    public static final SelenideElement emailField = $(byId("field-email"));
    public static final SelenideElement passwordField = $(byId("field-password"));
    public static final SelenideElement termsAndConditionsCheckbox = $(byAttribute("name", "psgdpr"));
    public static final SelenideElement dataPrivacyCheckbox = $(byAttribute("name", "customer_privacy"));
    public static final SelenideElement saveFormButton = $(byAttribute("data-link-action", "save-customer"));
}
