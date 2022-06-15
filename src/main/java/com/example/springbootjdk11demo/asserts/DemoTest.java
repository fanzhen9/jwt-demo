package com.example.springbootjdk11demo.asserts;

import org.springframework.util.Assert;

public class DemoTest {

    public void test(){
        Assert.isNull("","消息不能为空");

    }
}
