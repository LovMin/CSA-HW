package com.rainsoul.hw1;

import java.util.Scanner;

public class hw1 {
    public static void main(String[] args) {

        System.out.println("第一题答案 = B");
        System.out.println("第二题答案 = B");
        System.out.println("第三题答案 = D");
        System.out.println("第四题答案 = B");
        System.out.println("第五题答案 = D");

        //1
        showTriangle(5);

        //2
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个正整数：");
        String input = scanner.next();
        scanner.close();

        int digitCount = input.length(); // 计算位数
        System.out.println("这个数有 " + digitCount + " 位");

        reverseDigits(input); // 逆序打印各位数字

        //3
        int num = 12321;
        isPalindrome(num);

        //4
        ShuiXianHua();

        //5
        MinMaxSum();
    }

    public static void showTriangle(int n) {
        for (int i = 1; i <= n; i++) {//控制行数
            for (int k = 1; k <= n - i; k++) {//控制空格的个数
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {//控制打印的图形
                System.out.print("*");
            }
            System.out.println();//控制换行
        }
    }

    public static void reverseDigits(String s) {
        char[] chars = s.toCharArray(); // 字符串转字符数组
        StringBuilder reversed = new StringBuilder(chars.length);

        for (int i = chars.length - 1; i >= 0; i--) {
            if (Character.isDigit(chars[i])) { // 验证字符是否为数字
                reversed.append(chars[i]);
            }
        }

        System.out.println("逆序输出各位数字为：" + reversed.toString());
    }

    public static void isPalindrome(int num) {
        // 将整数转换为字符串以便进行比较
        String strNum = String.valueOf(num);

        // 创建一个临时字符串用于存储翻转后的数字
        StringBuilder reversedStr = new StringBuilder(strNum);

        // 翻转字符串
        reversedStr.reverse();

        // 检查原字符串和翻转后的字符串是否相等
        boolean flag = strNum.equals(reversedStr.toString());

        // 根据结果打印输出
        if (flag) {
            System.out.println("是回文数");
        } else {
            System.out.println("不是回文数");
        }
    }

    public static void ShuiXianHua() {
        StringBuilder result = new StringBuilder();

        // 遍历所有三位数
        for (int i = 100; i <= 999; i++) {
            if (isNarcissistic(i)) {
                // 如果是水仙花数，则添加到结果字符串中，并用空格分隔
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(i);
            }
        }

        // 打印所有找到的水仙花数
        System.out.println(result.toString());
    }

    // 检查一个数是否为水仙花数的方法
    public static boolean isNarcissistic(int number) {
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int ones = number % 10;

        return (Math.pow(hundreds, 3) + Math.pow(tens, 3) + Math.pow(ones, 3)) == number;
    }


        public static void MinMaxSum() {
            int[] array = new int[10];

            // 假设我们从键盘获取这些整数，这里为了简化直接初始化一些随机整数
            for (int i = 0; i < array.length; i++) {
                array[i] = (int)(Math.random() * 100); // 初始化为0到99之间的随机数
            }

            // 计算并打印最小值和最大值之和
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int value : array) {
                if (value < min) {
                    min = value;
                }
                if (value > max) {
                    max = value;
                }
            }

            int sum = min + max;
            System.out.println("数组中最小值和最大值之和为: " + sum);
        }

}
