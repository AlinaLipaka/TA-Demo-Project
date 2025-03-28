package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public static final SelenideElement mainShopLogo = $(byId("logo"));
    public static final SelenideElement imageCarousel = $(byId("carousel"));
    public static final SelenideElement loadingMessage = $(byId("loadingMessage"));
    public static final SelenideElement signInButton = $(byXpath("//div[@class='user-info']/a"));
    public static final SelenideElement createAccountButton = $(byXpath("//a[contains(@href, '/registration')]"));
    public static final SelenideElement logOutButton = $(byXpath("//a[contains(@href, '/?mylogout')]"));
    public static final SelenideElement cartButton = $(byId("_desktop_cart"));

    //shopping
    public static final SelenideElement accessoriesButton = $(byId("category-6"));
    public static final SelenideElement homeAccessoriesButton = $(byXpath("//a[contains(@class, 'dropdown-item') and contains(@href, '8-home-accessories')]"));
}
