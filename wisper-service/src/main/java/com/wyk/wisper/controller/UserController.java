package com.wyk.wisper.controller;

import com.wyk.RepeatSubmit;
import com.wyk.wisper.mapper.UserMapper;
import com.wyk.wisper.pojo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wuyongkang
 * @date 2021年06月11日 18:48
 */
@RestController
@Controller
@Api("用户管理")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @ApiOperation("查询用户")
    @RequestMapping("/index")
    @RepeatSubmit
    public String test() {
        User user = userMapper.queryById(3);

        return user.toString();

    }
    @ApiOperation("添加用户")
    @RequestMapping("/add")
    public String add() {
        List<User> users = userMapper.queryAllByLimit(0, 5);
        return Integer.valueOf(users.size()).toString();

    }
    @ApiOperation("更新用户")
    @RequestMapping("/uptate/{id}")
    public String uptate(@PathVariable("id") int id) {
        String sql = "update test.user set name=?,password=?,email=? where id=" + id;
        Object[] objects = new Object[3];
        objects[0] = "wrwer0";
        objects[1] = "213333";
        objects[2] = "213333";
        return "sucess";

    }
    @ApiOperation("删除用户")
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        String sql = "delete from test.user where id=?";


        return "sucess";

    }
}