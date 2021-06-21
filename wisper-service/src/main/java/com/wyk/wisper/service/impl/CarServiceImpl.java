package com.wyk.wisper.service.impl;


import com.wisper.api.CarService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author wuyongkang
 * @date 2021年06月20日 19:52
 */
@Component
@Service
public class CarServiceImpl implements CarService {
    @Override
    public String buyCar() {
        return "买车了";
    }
}