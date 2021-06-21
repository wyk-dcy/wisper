package com.wyk.wisper.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author wuyongkang
 * @date 2021年06月18日 13:38
 */
@Service
public class ScheduledService {
    @Scheduled(cron = "0 50 13 * * ?")
    public void hello(){
        System.out.println("wuyongkag你在喊什么");
    }
}