package com.springboot.provider;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctc.wstx.sw.EncodingXmlWriter;
import io.seata.spring.annotation.GlobalTransactional;
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
public class Test1ServiceImpl extends ServiceImpl<Test1Mapper, Test1> implements ITest1Service {

    @Override
//    @GlobalTransactional(rollbackFor = Exception.class)
    public void create() throws Exception {
        Test1 test1 = new Test1();
        test1.setName("tel2");
        this.save(test1);
        Thread.sleep(10000);
        throw new Exception("provider执行失败！！");
    }
}
