package helpers;

public class World {

    private static String newUserEmail;

    private static double cartItemPrice;
    private static double cartTotalPrice = 0.0;
    private static int totalItemQty;

    public static double getCartItemPrice() {
        return cartItemPrice;
    }

    public static void setCartItemPrice(double cartItemPrice) {
        World.cartItemPrice = cartItemPrice;
    }

    public static double getCartTotalPrice() {
        return cartTotalPrice;
    }

    public static void setCartTotalPrice(double cartTotalPrice) {
        World.cartTotalPrice = cartTotalPrice;
    }

    public static String getNewUserEmail() {
        return newUserEmail;
    }

    public static void setNewUserEmail(String newUserEmail) {
        World.newUserEmail = newUserEmail;
    }

    public static int getTotalItemQty() {
        return totalItemQty;
    }

    public static void setTotalItemQty(int totalItemQty) {
        World.totalItemQty = totalItemQty;
    }
}
