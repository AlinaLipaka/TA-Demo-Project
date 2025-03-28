package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    public static final SelenideElement cartPageContent = $(byId("cart"));
    public static final SelenideElement cartTotalPrice = $(byCssSelector(".cart-total > .value"));

    public static final SelenideElement proceedToCheckoutBtn = $(byXpath("//div/a[contains(@href, '/order')]"));
    public static final SelenideElement shippingAddressForm = $(byId("checkout-addresses-step"));

    //Shipping address form
    public static final SelenideElement addressField = $(byXpath("//input[@id='field-address1']"));
    public static final SelenideElement cityField = $(byXpath("//input[@id='field-city']"));
    public static final SelenideElement zipCodeField = $(byXpath("//input[@id='field-postcode']"));
    public static final SelenideElement countryDropdown = $(byId("field-id_country"));
    public static final ElementsCollection countryOptionsList = $$(byXpath("//select[@id='field-id_country']/option"));
    public static final SelenideElement confirmAddressBtn = $(byAttribute("name", "confirm-addresses"));

    //Delivery method step
    public static final SelenideElement confirmDeliveryBtn = $(byAttribute("name", "confirmDeliveryOption"));

    //Place order step
    public static final SelenideElement termsAndCondCheckbox = $(byXpath("//input[contains(@id, 'conditions_to_approve')]"));
    public static final SelenideElement finalOrderPrice = $(byXpath("//*[@id='payment-option-3-additional-information']//dd[contains(text(), '€')]"));
    public static final SelenideElement placeOrderBtn = $(byXpath("//*[@id='payment-confirmation']/*/button"));

    //Order confirmed
    public static final SelenideElement orderConfirmedPageContent = $(byId("content-hook_order_confirmation"));
    public static final SelenideElement confirmedFinalValue = $(byXpath("//*[contains(@class, 'total-value')]/td[2]"));
    public static final SelenideElement confirmedPaymentMethod = $(byXpath("//li[contains(text(), 'Payment method')]"));
    public static final SelenideElement confirmedShippingMethod = $(byXpath("//li[contains(text(), 'Shipping method')]"));
}
