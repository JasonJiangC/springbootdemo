package com.springboot.consumer;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import feign.Feign;
import feign.hystrix.HystrixFeign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixConfiguration {
//    @Bean
//    public Feign.Builder feignHystrixBuilder() {
//        return HystrixFeign.builder().setterFactory((target, method) -> {
//            String groupKey = target.name();
//            String commandKey = Feign.configKey(target.type(), method);
//            return HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey))
//                    .andCommandKey(HystrixCommandKey.Factory.asKey(commandKey))
////                    .andCommandKey(HystrixCommandKey.Factory.asKey(groupKey))
////                    .andCommandKey(HystrixCommandKey.Factory.asKey(target.type().getSimpleName()))
//                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
//                            .withExecutionTimeoutInMilliseconds(4000)
//                            .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD));
//        });
//    }
}
