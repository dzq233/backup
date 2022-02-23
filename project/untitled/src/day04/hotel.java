package day04;

import java.util.Scanner;

public class hotel {
    public static void in() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入年龄:");
        float a = scan.nextFloat();
        if (a < 18 || a > 90) {
            throw new Exception("当前年龄不允许入住");
        }
        System.out.println("年龄：" + a + ",欢迎入住");

    }

    public static void main(String[] args) {
        try {
            hotel.in();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();//输出异常信息
            System.out.println("出错了");
        }
    }

}