package com.oneapm.guice.javaAnnotations;

public class PasswordUtils {

    @UseCase(id = 47, description = "this is a test1")
    public boolean validataPassword(String password) {
        return (password.matches(""));
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "this is a test2")
    public String checkForNewPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }
}
