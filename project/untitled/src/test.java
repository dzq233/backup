import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个数");
        double y = 0;
        double x = scan.nextDouble();

        if (x < 0){
            x = y;
        }else if (1 <= x && x < 10){
            y = 2*x + 3;
        }else{
            y = x/2-4;
        }
        System.out.println(y);
    }
}
