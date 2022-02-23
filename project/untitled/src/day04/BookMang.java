package day04;

import java.util.Scanner;

public class BookMang {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("输入图书名称:");
            String name = scan.next();//不能接受空格，会将空格作为结束
            String n = scan.nextLine();//以回车作为结束
            System.out.println("请输入库存:");
            int number = scan.nextInt();
            System.out.println(name);
            System.out.println(number);
        } catch (Exception e) {
            System.out.println("出错了");
        }
    }

}
