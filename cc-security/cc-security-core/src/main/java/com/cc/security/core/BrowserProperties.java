package com.cc.security.core;

public class BrowserProperties {

    private String loginPage = "/cc-signIn.html";

    public String getLoginPage() {
        return loginPage;
    }

    public BrowserProperties setLoginPage(String loginPage) {
        this.loginPage = loginPage;
        return this;
    }
}
