package com.example.toystory.Service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(
        scopeName = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS
)
public class VisitCounter {
    private int visits = 0;

    public int incrementAndGet(){
        return ++visits;
    }
    public void reset(){
        visits = 0;
    }
}
