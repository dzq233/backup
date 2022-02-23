package study;


public class Day01 {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            if (i % 4 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }
}