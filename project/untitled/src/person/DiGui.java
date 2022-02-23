package person;

public class DiGui {
    static long demo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return demo(n - 1) + demo(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(DiGui.demo(10));
    }
}
