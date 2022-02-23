package day04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Divi {
    public static void info() {

    }

    public static void main(String[] args) {
        try {
            int a, b;
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入被除数:");
            a = scan.nextInt();
            System.out.println("请输入除数:");
            b = scan.nextInt();
            System.out.println("商=" + (a / b));
        } catch (InputMismatchException e1) {
            System.out.println("只能输入整数");
        } catch (ArithmeticException e2) {
            System.out.println("0不能为除数");
        } catch (Exception e) {
            System.out.println("出错了");
        }
    }

}