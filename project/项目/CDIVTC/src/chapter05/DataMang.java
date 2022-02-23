package chapter05;

import java.util.Scanner;

public class DataMang {
    public static void menu() {
        System.out.println("--------------");
        System.out.println("--1.��������-------");
        System.out.println("--2.��������-------");
        System.out.println("--3.����������-----");
        System.out.println("--4.�ܱ�3��������---");
        System.out.println("--------------");
    }

    public static void show(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[4];
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            DataMang.menu();
            System.out.println("�����빦�ܲ˵���");
            n = sc.nextInt();
            if (n >= 1 && n <= 4) {
                switch (n) {
                    case 1:
                        for (int i = 0; i < a.length; i++) {
                            System.out.println("�������" + (i + 1) + "������");
                            a[i] = sc.nextInt();
                        }
                        break;
                    case 2:
                        if (a[0] == 0) {
                            System.out.println("���������0����");
                        } else {
                            DataMang.show(a);
                        }
                        break;
                    case 3:
                        if (a[0] == 0) {
                            System.out.println("���������0����");
                        } else {
                            System.out.println("������Ҫ�޸ĵڼ������֣�");
                            int k = sc.nextInt();
                            System.out.println("�����������֣�");
                            a[k - 1] = sc.nextInt();
                            DataMang.show(a);
                        }
                        break;
                    case 4:
                        if (a[0] == 0) {
                            System.out.println("���������0����");
                        } else {
                            System.out.println("�ܱ�3����������");
                            for (int i : a) {
                                if (i % 3 == 0) {
                                    System.out.print(i + " ");
                                }
                            }
                            System.out.println();
                        }
                        break;
                }
            } else {
                System.out.println("���빦�ܲ���ȷ");
            }
        }
    }
}
