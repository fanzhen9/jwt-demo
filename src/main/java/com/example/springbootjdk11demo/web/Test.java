package com.example.springbootjdk11demo.web;

import com.example.springbootjdk11demo.annoation.NoToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class Test {


    private static Map<String,Double> map = new ConcurrentHashMap<>();


    @GetMapping("/getCount")
    @NoToken
    public String getCount(String taskId){
        return String.valueOf(map.get(taskId));
    }


    @GetMapping("/doWord")
    @NoToken
    public String doWord(){
        String id = UUID.randomUUID().toString();
        new Thread(()->{
            double d = 0d;
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                d++;
                map.put(id, d);
            }
        }).start();
        return id;
    }
}
