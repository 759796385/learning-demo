package com.newtonk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：
 * 类描述：
 * 创建人：tq
 * 创建日期：2017/5/23 0023
 */
@RestController
@RequestMapping(value = "/main")
public class MyController {

    @GetMapping(value = "")
    public Object first(){
        return "";
    }
}
