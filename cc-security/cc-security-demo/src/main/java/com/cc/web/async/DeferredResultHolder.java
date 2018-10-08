package com.cc.web.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

@Component
public class DeferredResultHolder {

    private Map<String,DeferredResult<String>> map = new HashMap<>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public DeferredResultHolder setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DeferredResultHolder{");
        sb.append("map=").append(map);
        sb.append('}');
        return sb.toString();
    }
}
