package com.example.springbootjdk11demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootTest
class SpringbootJdk11DemoApplicationTests {

    @Test
    void contextLoads() {

        //Assert.isNull(null,"消息不能为空");
        try {
            /*String str = FileCopyUtils.copyToString(new InputStreamReader(new FileInputStream("d://new 2.java")));
            System.out.println(str);*/
            FileCopyUtils.copy(new File("d://new 2.java"),new File("d://new 23.java"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
