package com.example.springbootdemo.demos.util;

import java.util.Scanner;

/**
 * 字符串序列判定
 */
public class StringTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String l = scanner.nextLine();
        int indexS = 0;
        int indexL = 0;
        while (indexS < s.length() && indexL < l.length()) {
            if (s.charAt(indexS) == l.charAt(indexL)) {
                indexS++;
            }
            indexL++;
        }
        if(indexS == s.length()){
            System.out.println(indexL-1);
        }else{
            System.out.println(-1);
        }
    }

}
