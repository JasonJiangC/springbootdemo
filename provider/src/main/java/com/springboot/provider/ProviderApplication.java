package com.springboot.provider;

import com.springboot.api.feignclient.Params;
import feign.QueryMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}

	@GetMapping("/test")
	public String test(){
		return "hello world!!";
	}

	@GetMapping(path = "/demo")
	String demoEndpoint(@QueryMap Params params){
		return params.getParam1()+params.getParam2();
	}
}
