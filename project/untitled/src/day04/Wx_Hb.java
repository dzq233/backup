package day04;

import java.text.DecimalFormat;
import java.util.Random;

public class Wx_Hb {
    public static void money(double a, int b) {
        double min = 0.01;
        Random r = new Random();
        DecimalFormat d = new DecimalFormat("0.00");
        System.out.println("红包总额：" + a + "红包个数：" + b);
        for (int i = 0; i < (b + 1); i++) {
            String h = d.format(r.nextDouble() * (a - min) + min);
            //每次循环的红包金额=总金额-已取出金额-最小红包
            a = a - Double.parseDouble(h);
            System.out.println("第" + (i + 1) + "个红包：" + h + "元");
        }

    }

    public static void main(String[] args) {
        Wx_Hb.money(20.0, 5);
    }
}