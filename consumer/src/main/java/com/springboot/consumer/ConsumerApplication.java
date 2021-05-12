package com.springboot.consumer;

import com.springboot.api.feignclient.ITestService;
import com.springboot.api.feignclient.Params;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan("com.springboot")
@RestController
@EnableFeignClients(basePackages = "com.springboot.api.feignclient")
@EnableTransactionManagement
@MapperScan("com.springboot.consumer")
//@EnableDiscoveryClient
//@EnableCircuitBreaker
public class ConsumerApplication {
    @Autowired
    private ITestService testService;
	@Autowired
	private TestServiceImpl iTestService;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@GetMapping("/test")
//	@Transactional
	public String test(){
		Test test = new Test();
//		test.setId(1);
		test.setDes("ces");
		iTestService.save(test);
//		return testService.test();
		return test.getDes();
	}

	@GetMapping(path = "/demo")
	String demoEndpoint(@SpringQueryMap Params params){
		return testService.demoEndpoint(params);
	}



}
