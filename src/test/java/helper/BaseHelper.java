package helper;

import org.apache.commons.lang3.RandomStringUtils;

public class BaseHelper {
    private String passwordCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
    private String emailCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public String getNewEmail() {
        String email = RandomStringUtils.random( 10, emailCharacters).concat("@aloha.com");
        return email;
    }

    public String getPassword() {
        return RandomStringUtils.random( 10, passwordCharacters);
    }

}
