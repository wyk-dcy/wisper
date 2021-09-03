package com.wyk.wisper.utils;

import com.wyk.wisper.pojo.entity.ModbusDomain;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CSVWriterUtils {



	/**
	 * 写CSV文件
	 *
	 * @param fileName    csv文件名称
	 * @param fileHeader 文件头
	 * @param content    内容
	 * @throws IOException
	 */
	public static void write(final String fileName, final String[] fileHeader, List<String[]> content) {
		try {
			Appendable fileWriter = new FileWriter(fileName);
			CSVPrinter printer = CSVFormat.RFC4180.withHeader(fileHeader).print(fileWriter);
			for (int i = 0; i < content.size(); i++) {
				printer.printRecord((Object) content.get(i));
			}
			printer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读CSV文件
	 *
	 * @param fileName    csv文件名称
	 * @throws IOException
	 */
	public static void reader(String fileName,Object o) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
		Class<?> aClass = o.getClass();
		System.out.println("Class name: " + aClass.getName());
		System.out.println("Simple name: " + aClass.getSimpleName());
		System.out.println(aClass.getField("index"));
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
		CSVWriterUtils.reader("", new ModbusDomain());
	}
}