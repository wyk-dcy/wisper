package com.wyk.wisper.design.patterns.factory.simple;

/**
 * @author wuyongkang
 * @date 2021年08月06日 10:39
 */
public class ExportTxtFileOperate extends ExportOperate{
    @Override
    protected ExportApi factoryMethod() {
        return new ExportTxtFile();
    }
}