package com.wyk.wisper.swing;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;

/**
 * @author wuyongkang
 * @date 2021年07月20日 15:29
 */
public class FileChooser {
    public static void main(String[] args) {

        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY);
        jf.showDialog(null,null);
        File fi = jf.getSelectedFile();
        String f = fi.getAbsolutePath()+"\\test.txt";
        System.out.println("save: "+f);
        try{
            FileWriter out = new FileWriter(f);
            out.write("successful!!!");
            out.close();
        }
        catch(Exception e){}
    }

}