package com.springboot.provider;

import com.springboot.api.feignclient.Params;
import feign.QueryMap;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan("com.springboot")
@RestController
//@EnableFeignClients(basePackages = "com.springboot.api.feignclient")
@EnableTransactionManagement
@MapperScan("com.springboot.provider")
public class ProviderApplication {
	@Autowired
	private Test1ServiceImpl test1Service;

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}

	@GetMapping("/test")
	public String test() throws Exception {
		test1Service.create();
		return "hello world!!";
	}

	@GetMapping(path = "/demo")
	String demoEndpoint(@QueryMap Params params){
		return params.getParam1()+params.getParam2();
	}
}
