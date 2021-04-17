package com.springboot.consumer;

import com.springboot.api.feignclient.ITestService;
import org.springframework.cloud.openfeign.FeignClient;


public interface TestService extends ITestService {
}
