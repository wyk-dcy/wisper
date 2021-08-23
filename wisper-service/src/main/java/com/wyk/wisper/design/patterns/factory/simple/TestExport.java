package com.wyk.wisper.design.patterns.factory.simple;

/**
 * @author wuyongkang
 * @date 2021年08月06日 10:40
 */
public class TestExport {
    public static void main(String[] args) {
        ExportOperate exportOperate = new ExportDbFileOperate();
        exportOperate.export("123");
    }
}