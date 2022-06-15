package com.example.springbootjdk11demo.annoation;

import java.lang.annotation.*;

/**
 * @author fox
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoToken {

}
