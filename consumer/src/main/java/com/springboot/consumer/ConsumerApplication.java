package com.springboot.consumer;

import com.springboot.api.feignclient.ITestService;
import com.springboot.api.feignclient.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan("com.springboot")
@RestController
@EnableFeignClients(basePackages = "com.springboot.api.feignclient")
//@EnableDiscoveryClient
//@EnableCircuitBreaker
public class ConsumerApplication {
    @Autowired
    private ITestService testService;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@GetMapping("/test")
	public String test(){
		return testService.test();
	}

	@GetMapping(path = "/demo")
	String demoEndpoint(@SpringQueryMap Params params){
		return testService.demoEndpoint(params);
	}
}
