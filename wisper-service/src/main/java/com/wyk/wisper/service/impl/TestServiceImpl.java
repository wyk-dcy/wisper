package com.wyk.wisper.service.impl;

import com.wyk.wisper.aspect.ApiLog;
import com.wyk.wisper.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author wuyongkang
 * @date 2021年07月14日 14:38
 */
@Service
public class TestServiceImpl implements TestService {
    @ApiLog(title = "注解的标题",isSaveRequestData = false)
    @Override
    public void save(String parm1,int parm2){
        System.out.println("执行目标对象的方法"+parm1+parm2);
    }

    @Override
    public void  update(){
        System.out.println("没有注解的方法，不会被拦截");
    }
}