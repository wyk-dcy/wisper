package com.wyk.wisper.lambda.impl;

import com.wyk.wisper.lambda.PropertyValue;


/**
 * @author wuyongkang
 * @date 2021年08月16日 16:26
 */
public class PropertyValueImpl<T>  implements PropertyValue<T> {
    private T value;
    public PropertyValueImpl(T defaultValue) {
        this.value = defaultValue;
    }
    @Override
    public T getValue() {
        return value;
    }
}