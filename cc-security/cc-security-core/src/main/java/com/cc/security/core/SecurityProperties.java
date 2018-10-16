package com.cc.security.core;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cc.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public SecurityProperties setBrowser(BrowserProperties browser) {
        this.browser = browser;
        return this;
    }
}
