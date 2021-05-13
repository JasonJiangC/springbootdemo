package com.springboot.consumer;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.api.feignclient.ITestService;
import io.seata.spring.annotation.GlobalTransactional;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mybatis_plus_generator
 * @since 2021-05-12
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService1 {
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private ITestService testService;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void create(Integer a) throws Exception {
        Test test = new Test();
        test.setDes("ces");
//        testMapper.create(test);
        this.save(test);
        //远程过程调用
        String x = testService.test();
        System.out.println("======================================="+x);;
        if(a!=null&&a==1) {
            throw new Exception("consumer执行失败！！");
        }
    }
}
