package com.wyk.wisper.controller;

import com.wyk.RepeatSubmit;
import com.wyk.wisper.mapper.UserMapper;
import com.wyk.wisper.pojo.A;
import com.wyk.wisper.pojo.entity.User;
import com.wyk.wisper.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @Autowired
    private TestService testService;

    @ApiOperation("查询用户")
    @GetMapping("/index")
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
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        String sql = "delete from test.user where id=?";
        int i = userMapper.deleteById(id);
        return "sucess" + i;

    }

    @ApiOperation("提交用户")
    @RequestMapping("/commit/{id}")
    public String commit(@PathVariable("id") int id) {
        testService.save("111", 2);
        return "sucess";

    }

    @ApiOperation("测试")
    @RequestMapping("/jprofifer")
    public String Jprofifer() {
        byte[] array = new byte[1024 * 1024];
        ArrayList<byte[]> list = new ArrayList<byte[]>();
        int count = 0;
        try {
            while (true) {
                list.add(array);
                count = count + 1;
            }
        } catch (Exception e) {
            System.out.println(count);
            e.printStackTrace();
        }
        return "succ";
    }

    public static void main(String[] args) {

    }

}