package chapter03;

import java.util.Scanner;

public class Arrays {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		float[][] score = new float[2][2];
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				System.out.println("�������" + (i + 1) + "��ͬѧ�����ĳɼ�:");
				score[i][j] = scanner.nextFloat();
				System.out.println("�������" + (i + 1) + "��ͬѧ����ѧ�ɼ�:");
				score[i][j + 1] = scanner.nextFloat();
			}
		}
		int sum1 = 0, sum2 = 0;
		for (int i = 0; i < score.length; i++) {
			sum1 += score[i][0];
			sum2 += score[i][1];

		}
		System.out.println("����ƽ���ɼ�=" + (sum1 / 2));
		System.out.println("��ѧƽ���ɼ�=" + (sum2 / 2));
	}

}
