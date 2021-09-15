package com.wyk.wisper.service.impl;

import com.wyk.wisper.service.SystemConfigService;

import javax.inject.Singleton;
import java.io.*;
import java.util.Properties;

@Singleton
public class SystemConfigServiceImpl<K,V> implements SystemConfigService<K,V> {
    private final static String FILEPATH;

    static {
        String path = System.getProperty("user.home");
        FILEPATH = path + File.separator + "conf" + File.separator + "service.properties";
    }

    @Override
    public V writeSingleConfig(K key, V value) {
        Properties properties = new Properties();
        try {
            checkFileExist();
            FileOutputStream oFile = new FileOutputStream(FILEPATH);
            properties.store(oFile, "");
            oFile.close();
        } catch (IOException ex) {
        }
        return null;
    }

    @Override
    public String readSingleConfig(String key) {
        Properties properties = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(FILEPATH));
            properties.load(in);
        } catch (IOException e) {
            return "";
        }
        return properties.getProperty(key);
    }

    private void checkFileExist() {
        File file = new File(System.getProperty("user.home") + File.separator + "conf");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

}