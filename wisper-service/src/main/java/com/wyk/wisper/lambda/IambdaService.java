package com.wyk.wisper.lambda;

import org.apache.poi.ss.formula.functions.T;

import java.util.function.Consumer;

public interface IambdaService {
    void bind(PropertyValue<String> target, Consumer<String> body);
}
