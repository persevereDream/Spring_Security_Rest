package com.cc.security.browser.support;

public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public SimpleResponse setContent(Object content) {
        this.content = content;
        return this;
    }
}
