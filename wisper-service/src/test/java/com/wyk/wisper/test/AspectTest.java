package com.wyk.wisper.test;

import com.wyk.wisper.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AspectTest {
    @Autowired
    private TestService testService;
    @Test
    public void test() throws InterruptedException {
        testService.save("参数1字符串",33);

    }
}
