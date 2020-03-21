package com.huae.ch3.fortest;

import com.huae.ch3.fortest.bean.ForTestBean;
import com.huae.ch3.fortest.config.ForTestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ForTestConfig.class)
//@ActiveProfiles("dev")
@ActiveProfiles("prod")
public class TestClass {

    @Autowired
    private ForTestBean forTestBean;

    @Test
    public void test() {
//        Assert.assertEquals("dev",forTestBean.out());
        Assert.assertEquals("prod", forTestBean.out());
    }
}