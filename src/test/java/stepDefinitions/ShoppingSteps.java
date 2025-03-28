package stepDefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.World;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.ShoppingPage;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.actions;
import static org.junit.Assert.assertEquals;

public class ShoppingSteps {

    @And("I filter items by price from {int} to {int}")
        public void iFilterItemsByPriceFromTo(int rangeFrom, int rangeTo) throws InterruptedException {
        SelenideElement leftSlider = ShoppingPage.priceSliders.get(0);
        SelenideElement rightSlider = ShoppingPage.priceSliders.get(1);

        Actions action = new Actions(Selenide.webdriver().object());
        action.dragAndDropBy(leftSlider, 31, 0).perform();
        Thread.sleep(1000);
        action.dragAndDropBy(rightSlider, -143, 0).perform();
        Thread.sleep(1000);
    }

    @Then("All item prices are in range from {double} to {double}")
    public void allItemPricesAreInRangeFromTo(double priceFrom, double priceTo) {
        List<String> strPrices = ShoppingPage.itemPrices.texts();

        double[] doublePrices = strPrices.stream()
                .map(price -> price.replace("€", ""))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Assert.assertTrue(arePricesInRange(doublePrices, priceFrom, priceTo));
    }

    static boolean arePricesInRange(double [] prices, double from, double to) {
        for (double price : prices) {
            if (price < from || price > to) {
                return false;
            }
        }
        return true;
    }

    @And("I increase item quantity for {int}")
    public void iIncreaseItemQuantityFor(int qty) {
        for (int i = 0; i < qty; i++) {
            ShoppingPage.increaseQtyBtn.click();
        }
    }

    @When("I open quick view for first filtered item")
    public void iOpenQuickViewForFirstFilteredItem() throws InterruptedException {
        Thread.sleep(2000);
        actions().moveToElement(ShoppingPage.productThumbnails.get(0).shouldBe(Condition.visible, Duration.ofSeconds(2))).build().perform();
        ShoppingPage.itemQuickViewButton.get(0).shouldBe(Condition.visible, Duration.ofSeconds(2)).click();
    }

    @And("I click \"Add to cart\" button in quick view")
    public void iClickButtonInQuickView() {
        int qty = Integer.parseInt(Objects.requireNonNull(ShoppingPage.itemQtyAddToCart.getAttribute("value")));
        double pricePerItem = Double.parseDouble(Objects.requireNonNull(ShoppingPage.quickViewItemPrice.getAttribute("content")));

        World.setCartItemPrice(pricePerItem * qty);
        World.setCartTotalPrice(World.getCartTotalPrice() + pricePerItem * qty);
        ShoppingPage.addToCartBtn.shouldBe(Condition.visible, Duration.ofSeconds(2)).click();
    }

    @Then("Success modal is displayed")
    public void successModalIsDisplayed() {
        ShoppingPage.successModalMessage.shouldBe(Condition.visible, Duration.ofSeconds(2));
    }

    @When("I close success modal window")
    public void iCloseSuccessModalWindow() {
        ShoppingPage.closeSuccessModal.shouldBe(Condition.visible).click();
    }

    @When("I open quick view for filtered item {int} of the list")
    public void iOpenQuickViewForFilteredItemOfTheList(int itemNumber) throws InterruptedException {
        Thread.sleep(2000);
        actions().moveToElement(ShoppingPage.productThumbnails.get(itemNumber-1).shouldBe(Condition.visible, Duration.ofSeconds(2))).build().perform();
        ShoppingPage.itemQuickViewButton.get(itemNumber-1).shouldBe(Condition.visible, Duration.ofSeconds(2)).click();
    }

    @And("I can see items in Shop")
    public void iCanSeeItemsInShop() {
        ShoppingPage.shopItemsSection.shouldBe(Condition.visible, Duration.ofSeconds(2));
    }

    @And("I can see correct total items price in success modal")
    public void iCanSeeCorrectTotalItemPriceInSuccessModal() {
        double modalItemPrice = Double.parseDouble(ShoppingPage.successModalTotalPrice.getText().replaceAll("€", ""));
        assertEquals(World.getCartTotalPrice(),modalItemPrice, 0.001);
    }
}