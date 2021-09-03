package com.wyk.wisper.lambda.impl;

import com.wyk.wisper.lambda.IambdaService;
import com.wyk.wisper.lambda.PropertyValue;
import org.apache.poi.ss.formula.functions.T;

import java.util.function.Consumer;

/**
 * @author wuyongkang
 * @date 2021年08月16日 16:22
 */
public class IambdaServiceImpl implements IambdaService {

    @Override
    public void bind(PropertyValue<String> target,Consumer<String> body) {
        body.accept("AAAAA");
        System.out.println("----------");

    }

    public static void main(String[] args) {
        IambdaServiceImpl iambdaService = new IambdaServiceImpl();
        iambdaService.bind(new PropertyValueImpl<>("123"),value-> System.out.println(value));

    }
}