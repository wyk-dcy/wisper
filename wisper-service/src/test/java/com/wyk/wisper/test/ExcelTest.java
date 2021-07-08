package com.wyk.wisper.test;

import com.alibaba.excel.EasyExcel;
import com.wyk.wisper.utils.CSVWriterUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Test
    public void demo() throws IOException {
        String fileName = "D:\\work\\tool\\workspace\\wisper测试.xlsx";
        EasyExcel.write(fileName).head(head()).sheet("模板").doWrite(dataList());
    }

    private List<List<String>> head() {
        List<List<String>> list = new ArrayList<>();
        List<String> head0 = new ArrayList<>();
        head0.add("姓名");
        List<String> head1 = new ArrayList<>();
        head1.add("年龄");
        List<String> head2 = new ArrayList<>();
        head2.add("生日");
        list.add(head0);
        list.add(head1);
        list.add(head2);
        return list;
    }

    private List<List<Object>> dataList() {
        List<List<Object>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Object> data = new ArrayList<>();
            data.add("张三");
            data.add(25);
            data.add(new Date());
            list.add(data);
        }
        return list;
    }

    @Test
    public void testCSV() throws IOException {
        String[] strings = {"1", "2", "3", "4"};
        List<String[]> list = new ArrayList<String[]>();
        list.add(new String[] {"1", "Sundar Pichai ♥", "CEO", "Google"});
        list.add(new String[] {"2", "Satya Nadella", "CEO", "Microsoft"});
        list.add(new String[] {"3", "Tim cook", "CEO", "Apple"});
        list.add(new String[] {"4", "Mark Zuckerberg", "CEO", "Facebook"});
        CSVWriterUtils.write("D:\\work\\tool\\workspace\\wisper\\测试.csv",strings,list);


    }


}
