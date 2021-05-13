package com.springboot.consumer;

import com.springboot.api.feignclient.ITestService;
import com.springboot.api.feignclient.Params;
import io.seata.spring.annotation.GlobalTransactional;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
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
//	@GlobalTransactional(rollbackFor = Exception.class)
	public String test(@RequestParam("p")Integer p) throws Exception {

		iTestService.create(p);
//		return testService.test();
		return "success";
	}

	@GetMapping(path = "/demo")
	String demoEndpoint(@SpringQueryMap Params params){
		return testService.demoEndpoint(params);
	}



}
