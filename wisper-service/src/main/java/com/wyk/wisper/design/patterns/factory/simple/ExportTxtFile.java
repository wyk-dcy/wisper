package com.wyk.wisper.design.patterns.factory.simple;

/**
 * @author wuyongkang
 * @date 2021年08月06日 10:29
 */
public class ExportTxtFile implements ExportApi{
    @Override
    public void export() {
        System.out.println("生成文件");
    }
}