package com.example.springbootjdk11demo.web;

import com.example.springbootjdk11demo.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {



    @GetMapping("/queryOrder")
    public ResponseVO<List<String>> queryOrder(){
        List<String> list = new ArrayList<>();
        list.add("方便面");
        list.add("薯片");
        list.add("雪糕");

        ResponseVO<List<String>> responseVO = new ResponseVO();
        responseVO.setCode(0);
        responseVO.setMessage("查询成功");
        responseVO.setData(list);

        return responseVO;
    }
}
