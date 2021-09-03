package com.wyk.wisper.pojo;


import com.wyk.wisper.pojo.entity.ModbusDomain;

import javax.inject.Singleton;
import java.util.ArrayList;

/**
 * @author wuyongkang
 * @date 2021年07月23日 11:43
 */
@Singleton
public class A {
    public static void main(String[] args) {
        ArrayList<ModbusDomain> array = new ArrayList<>();
        array.add(new ModbusDomain());
        array.add(new ModbusDomain());
        array.add(new ModbusDomain());
        array.add(new ModbusDomain());
        array.add(new ModbusDomain());
        array.add(new ModbusDomain());
        array.add(new ModbusDomain());
        array.add(new ModbusDomain());
        array.add(new ModbusDomain());
        array.add(new ModbusDomain());
        array.add(new ModbusDomain());
        array.add(new ModbusDomain());


        ArrayList<ModbusDomain> arrayList =new ArrayList<>(array);

    }
}