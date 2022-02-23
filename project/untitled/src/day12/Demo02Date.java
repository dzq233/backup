package day12;

import java.util.Date;

public class Demo02Date {
    public static void main(String[] args) {
        demo03();
    }

    /*
    Long getTime()把日期转换为毫秒(相当于System.currentTimeMillis())

    返回自1970年1月1日 00：00：00 GMT以来此Date对象表示的毫秒数。
     */
    private static void demo03() {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
    }

    /*
    Date类的带参数构造方法
    Date(Long date) :传递毫秒值，把毫秒值转换为Date日期
     */
    private static void demo02() {
        Date date = new Date(0L);
        System.out.println(date);

        date = new Date(1621247761702L);
        System.out.println(date);
    }

    /*
    Date类的空参数构造方法
    Date()获取当前系统的日期和时间
     */
    private static void demo01() {
        Date date = new Date();
        System.out.println(date);
    }
}
