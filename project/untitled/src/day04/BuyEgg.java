package day04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BuyEgg {
    public static void buy() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入购买鸡蛋的重量：");
        float a = scan.nextFloat();
        if (a > 3) {
            throw new Exception("购买异常");
        }
        System.out.println("应付款" + (4 * a) + "元");
    }

    public static void main(String[] args) {
        try {
            BuyEgg.buy();
        } catch (InputMismatchException e1) {
            System.out.println("只能输入整数");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}