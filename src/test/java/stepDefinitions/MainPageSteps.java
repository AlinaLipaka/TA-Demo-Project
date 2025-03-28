package stepDefinitions;

import helpers.YamlReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.MainPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageSteps {

    private final YamlReader yamlReader = new YamlReader("test.yaml");

    @Given("I open Shop page")
    public void iOpenShopPage() {
        open(yamlReader.getUrl());
        MainPage.mainShopLogo.shouldBe(visible, Duration.ofSeconds(2));
        MainPage.loadingMessage.shouldBe(visible, Duration.ofSeconds(1));
        MainPage.loadingMessage.shouldNotBe(visible, Duration.ofSeconds(15));
        switchTo().frame($("iframe#framelive"));
        MainPage.imageCarousel.shouldBe(visible, Duration.ofSeconds(2));

    }

    @And("I click {string} button")
    public void iClickButton(String buttonName) throws Exception {
        switch (buttonName) {
            case "Sign in":
                MainPage.signInButton.click();
                break;
            case "Create account":
                MainPage.createAccountButton.click();
                break;
            case "Sign out":
                MainPage.logOutButton.shouldBe(visible).click();
                break;
            default:
                throw new Exception("No button with name " + buttonName + " is available");
        }
    }

    @And("I am logged in")
    public void iAmLoggedIn() {
        MainPage.logOutButton.shouldBe(visible, Duration.ofSeconds(4));
    }

    @And("I navigate to {string} section")
    public void iNavigateToSection(String sectionName) {
        actions().moveToElement(MainPage.accessoriesButton).build().perform();
        MainPage.homeAccessoriesButton.shouldBe(visible, Duration.ofSeconds(3)).click();
    }

    @When("I navigate to cart")
    public void iNavigateToCart() {
        MainPage.cartButton.shouldBe(visible, Duration.ofSeconds(2)).click();
        CartPage.cartPageContent.shouldBe(visible, Duration.ofSeconds(2));
    }

    @Then("I am not signed in")
    public void iAmNotLoggedIn() {
        MainPage.signInButton.shouldBe(visible, Duration.ofSeconds(3));
    }
}
