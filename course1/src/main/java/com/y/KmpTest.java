package com.y;

import java.util.Arrays;

public class KmpTest {

    public static void main(String[] args) {
        //主串
        String t = "abacaabacabacabaabb";
        //匹配串
        String m = "abacab";

        System.out.println("长度：主串t：" + t.length() + " ; 匹配串m: " + m.length());

        match1(m,t);
        match2(m,t);
    }

    private static void match1(String m,String t){

        int count = 0;
        char[] mm = m.toCharArray();
        char[] tt = t.toCharArray();

        L:
        for (int i = 0; i < tt.length; i++) {
            for (int j = 0; j < mm.length; j++) {
                count++;
                if(mm[j] != tt[i + j]){
                    continue L;
                }
            }
            System.out.println("1 匹配：index：" + i);
        }
        System.out.println("1 比对次数count: " + count);
    }

    private static void match2(String m,String t) {
        int count = 0;
        char[] mm = m.toCharArray();
        char[] tt = t.toCharArray();
        int[] next = new int[mm.length];
        next[0] = 0;

        int a = 1;
        int b = 0;
        while (a < mm.length){
            if(mm[a] == mm[b]){
                next[a] = b + 1;
                a++;
                b++;
            }else{
                next[a] = 0;
                a++;
                b = 0;
            }
        }

        System.out.println(Arrays.toString(next));

        int i = 0,j;
        L:
        while (i < tt.length){
            j = 0;
            while (j < mm.length){
                count++;
                if(mm[j] != tt[i + j]){
                    if(j == 0){
                        i++;
                    }else{
                        i += (j - next[j - 1]);
                    }
                    continue L;
                }
                j++;
            }
            System.out.println("2 匹配：index：" + i);
            i++;
        }
        System.out.println("2 比对次数count: " + count);
    }

}
