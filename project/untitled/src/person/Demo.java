package person;

public class Demo {
    static long digui(int n) {
        if (n == 1) {
            return 1;
        }
        return digui(n - 1) * n;
    }

    public static void main(String[] args) {
        System.out.println(Demo.digui(5));
    }
}
