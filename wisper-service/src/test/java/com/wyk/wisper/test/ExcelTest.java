package com.wyk.wisper.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author wuyongkang
 * @date 2021年06月21日 17:13
 */

public class ExcelTest {
    @Test
    public void test() throws IOException {
        //创建Workbook工作簿
        Workbook w = new HSSFWorkbook();
        //创建Sheet
        Sheet sheet = w.createSheet("Excel统计表");
        //创建行
        Row row = sheet.createRow(0);
        //创建列
        Cell cell = row.createCell(0);
        //设置改行该列的值
        cell.setCellValue("统计个数");
        cell = row.createCell(1);
        cell.setCellValue(666);
        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue("生成日期");
        cell = row.createCell(1);
        cell.setCellValue("date");
        //写入到文件
        String s = "D:\\work\\测试表.xls";
        FileOutputStream fo = new FileOutputStream(s);
        w.write(fo);
        fo.close();
    }

}