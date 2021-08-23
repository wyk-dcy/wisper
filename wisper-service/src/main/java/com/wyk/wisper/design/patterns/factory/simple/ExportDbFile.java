package com.wyk.wisper.design.patterns.factory.simple;

/**
 * @author wuyongkang
 * @date 2021年08月06日 10:30
 */
public class ExportDbFile implements ExportApi {

    @Override
    public void export() {
        System.out.println("数据库生成文件");
    }
}