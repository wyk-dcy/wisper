package com.wyk.wisper.service;

public interface SystemConfigService<K,V> {
    /**
     * 写单个配置
     *
     * @param key
     * @param value
     * @return
     */
    V writeSingleConfig(K key, V value);

    /**
     * 读单个配置
     *
     * @param key
     * @return
     */
    String readSingleConfig(String key);
}