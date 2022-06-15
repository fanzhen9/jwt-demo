package com.example.springbootjdk11demo.vo;

import lombok.Data;

@Data
public class ResponseVO<T> {


    private Integer code;

    private String message;

    private T data;
}
