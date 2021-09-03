package com.wyk.wisper.design.patterns.factory.simple;

/**
 * @author wuyongkang
 * @date 2021年08月06日 10:33
 */
public abstract class ExportOperate {
    public void export(String data){
        ExportApi api = factoryMethod();
        api.export();
    }

    protected abstract ExportApi factoryMethod();
}