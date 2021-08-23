package com.wyk.wisper.controller;

import com.wyk.wisper.pojo.A;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wuyongkang
 * @date 2021年07月22日 13:39
 */
@RestController
@Controller
@RequestMapping
@Api("定时管理")
public class ScheduledController {
    @Autowired
    private A a;
    @ApiOperation("定时任务")
    @RequestMapping("/add/scheduled")
    public String Scheduled() {
        System.out.println(a.hashCode());
        return "succes"+a.hashCode();
    }
}