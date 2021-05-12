package com.springboot.consumer;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

@Configuration
public class DataSourceProxyConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

//    @Bean
//    public DataSourceProxy dataSourceProxy(DataSource dataSource) {
//        return new DataSourceProxy(dataSource);
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
//        return sqlSessionFactoryBean.getObject();
//    }

//    @Bean
//    public TransactionManager transactionManager() {
//        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
//        transactionManager.setDataSource(dataSource());
//        return transactionManager;
//    }
}
