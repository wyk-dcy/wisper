package com.wyk.wisper.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModbusDomain {
    private Integer index;
    private Integer type;
    private String chineseFunctionName;
    private String englishFunctionName;
    private String readWrite;
}