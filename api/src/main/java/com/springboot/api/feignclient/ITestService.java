package com.springboot.api.feignclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "provider",url = "http://localhost:9090/provider")
//@FeignClient(name = "provider",path = "provider",fallback = TestServiceFallBack.class,configuration = FeignConfig.class)
@FeignClient(name = "provider",path = "provider",configuration = FeignConfig.class)
public interface ITestService {
    @GetMapping("/test")
    public String test();

    @GetMapping(path = "/demo")
    String demoEndpoint(@SpringQueryMap Params params);
}
