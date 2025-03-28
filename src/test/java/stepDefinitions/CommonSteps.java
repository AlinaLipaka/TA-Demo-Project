package stepDefinitions;

import helpers.World;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonSteps {

    public static String generateNewUserEmail() {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMHHmmss");
        String newUserId = "johndoe" + formatter.format(new Date()) + "@putsbox.com";
        World.setNewUserEmail(newUserId);
        return newUserId;
    }
}
