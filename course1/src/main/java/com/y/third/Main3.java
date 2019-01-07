package com.y.third;

public class Main3 {

    public static void main(String... args) {

        System.out.println(fib(10));
        System.out.println(fib(1, 1, 10));
        System.out.println(fibFor(10));

        hanoi(3,1,2,3);
    }


    /**
     * 递归实现
     */
    private static int fib(int n) {
        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }


    /**
     * 尾递归实现
     */
    private static int fib(int first, int second, int n) {
        if (n <= 2) return 1;
        int third = first + second;
        if (n == 3) return third;
        return fib(second, third, n - 1);
    }

    /**
     * 循环实现
     */
    static int a = 1,b = 1;
    private static int fibFor(int n){
        if(n <= 2) return 1;
        for (int i = 3; i <= n; i++) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
            b += a;
        }
        return b;
    }

    /**
     * 汉诺塔
     */
    private static int hanoiNum = 0;
    private static void hanoi(int n,int x,int y,int z){
        hanoiNum++;
        System.out.println("hanoiNum----->"+hanoiNum);
        if(n<=1){
            System.out.println(x+"----->"+z);
        }else{
            hanoi(n - 1,x,z,y);
            System.out.println(x+"----->"+z);
            hanoi(n - 1,y,x,z);
        }
    }
}
