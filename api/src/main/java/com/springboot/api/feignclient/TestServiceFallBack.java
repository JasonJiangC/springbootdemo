package com.springboot.api.feignclient;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TestServiceFallBack implements ITestService {
    @Override
    public String test() {
        return "失败！";
    }

    @Override
    public String demoEndpoint(Params params) {
        return "失败！";
    }
}
