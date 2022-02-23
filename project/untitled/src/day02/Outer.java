package day02;

public class Outer {
    private int a = 1;
    class Innter{
        public void show(){
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();//实例化外部类对象
        Outer.Innter innter = outer.new Innter();//实例化内部类对象
        innter.show();
    }
}
