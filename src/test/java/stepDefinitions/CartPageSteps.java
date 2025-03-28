package stepDefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.World;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CartPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

public class CartPageSteps {
    @Then("I can see correct total items price on Cart page")
    public void iCanSeeCorrectTotalItemsPriceOnCartPage() {
        double cartItemPrice = Double.parseDouble(CartPage.cartTotalPrice.getText().replaceAll("€", ""));
        assertEquals(World.getCartTotalPrice(), cartItemPrice, 0.001);
    }

    @And("I click {string} button in Cart")
    public void iClickButtonInCart(String buttonName) throws Exception {
        switch (buttonName) {
            case "Proceed to checkout":
                CartPage.proceedToCheckoutBtn.click();
                break;
            case "Place order":
                CartPage.placeOrderBtn.shouldBe(visible).click();
                break;
            case "Continue":
                CartPage.confirmAddressBtn.shouldBe(visible).click();
                break;
            default:
                throw new Exception("No button with name " + buttonName + " is available");
        }
    }

    @And("I can see shipping address form")
    public void iCanSeeShippingAddressForm() {
        CartPage.shippingAddressForm.shouldBe(Condition.visible, Duration.ofSeconds(2));
    }

    @And("I fill in the Shipping address form")
    public void iFillInTheShippingAddressForm() throws InterruptedException {
        CartPage.countryOptionsList.findBy(Condition.exactText("France")).shouldBe(Condition.visible, Duration.ofSeconds(2)).click();
        Thread.sleep(2000);
        CartPage.addressField.sendKeys("Jekaba 2");
        CartPage.cityField.sendKeys("Riga");
        CartPage.countryDropdown.click();
        CartPage.zipCodeField.sendKeys("12345");
    }

    @And("I confirm shipping method")
    public void iConfirmShippingMethod() {
        CartPage.confirmDeliveryBtn.shouldBe(Condition.visible, Duration.ofSeconds(2)).shouldBe(Condition.enabled).click();
    }

    @And("I am on shipping method step")
    public void iAmOnShippingMethodStep() {
        CartPage.confirmDeliveryBtn.shouldBe(Condition.visible);
    }

    @And("I am on the Payment method step")
    public void iAmOnThePaymentMethodStep() {
        CartPage.placeOrderBtn.shouldBe(Condition.visible);
    }

    @And("I choose {string} payment option")
    public void iChoosePaymentOption(String paymentOption) {
        SelenideElement paymentOptionBtn = $(byXpath("//*[text()='" + paymentOption + "']/ancestor::*[1]//span"));
        paymentOptionBtn.click();
    }

    @And("I agree to the terms of service on Cart page")
    public void iAgreeToTheTermsOfServiceOnCartPage() {
        CartPage.termsAndCondCheckbox.shouldBe(Condition.enabled).click();
    }

    @Then("I see the correct total price on Payment step")
    public void iSeeTheCorrectTotalPriceOnPaymentStep() {
        String cleanPriceText= "";
        String totalPriceText = (CartPage.finalOrderPrice.text()).replaceAll("[^0-9.]", "");

        if (totalPriceText.charAt(totalPriceText.length() - 1) == '.') {
            cleanPriceText = totalPriceText.substring(0, totalPriceText.length() - 1);
        }

        assertEquals(World.getCartTotalPrice(), Double.parseDouble(cleanPriceText), 0.001);
    }

    @Then("I am on Order confirmed page")
    public void iAmOnOrderConfirmedPage() {
        CartPage.orderConfirmedPageContent.shouldBe(Condition.visible, Duration.ofSeconds(3));
    }

    @And("I can see correct confirmed order details")
    public void iCanSeeCorrectConfirmedOrderDetails() {
        assertThat(CartPage.confirmedShippingMethod.getText()).contains("Click and collect");
        assertThat(CartPage.confirmedPaymentMethod.getText()).contains("Payments by check");

        double finalPrice = Double.parseDouble(CartPage.confirmedFinalValue.getText().replaceAll("€", ""));
        assertEquals(World.getCartTotalPrice(), finalPrice, 0.001);
    }
}
