package com.neo;

import java.io.*;

public class Test {
    public static void main(String[] args){

        test();
        System.out.println("test");
    }

    public static void test() {

        try (FileOutputStream out = new FileOutputStream(new File("D:/jdk8.txt"))) {

            //@SuppressWarnings("resource")
            //FileInputStream in = new FileInputStream(new File("D:/jdk8.txt"));

            //in.available();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
