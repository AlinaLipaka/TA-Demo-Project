package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingPage {
    public static final ElementsCollection priceSliders = $$(byClassName("ui-slider-handle"));
    public static final ElementsCollection itemPrices = $$(byCssSelector(".price"));
    public static final ElementsCollection productTitles = $$(byClassName("product-title"));
    public static final ElementsCollection productThumbnails = $$(byClassName("thumbnail-top"));
    public static final ElementsCollection itemQuickViewButton = $$(byClassName("quick-view"));
    public static final SelenideElement shopItemsSection = $(byId("products"));

    //item quick view
    public static final SelenideElement increaseQtyBtn = $(byXpath("//i[contains(@class, 'up')][contains(@class, 'touchspin')]"));
    public static final SelenideElement decreaseQtyBtn = $(byClassName("bootstrap-touchspin-down"));
    public static final SelenideElement itemQtyAddToCart = $(byId("quantity_wanted"));
    public static final SelenideElement quickViewItemPrice = $(byClassName("current-price-value"));
    public static final SelenideElement addToCartBtn = $(byClassName("add-to-cart"));

    //success modal
    public static final SelenideElement successModalMessage = $(byId("myModalLabel"));
    public static final SelenideElement closeSuccessModal = $(byXpath("//*[@id='blockcart-modal']//button[@class='close']"));
    public static final SelenideElement successModalTotalPrice = $(byCssSelector(".product-total > .value"));
}
