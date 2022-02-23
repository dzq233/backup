package person;

public class Demo1 {
    private String name;
    private int age;
    Demo1(String name,int age){
        System.out.println("有参构造");
        this.age = age;
        this.name = name;
    }
    public void say(){
        System.out.println("我叫"+name+"，我今年"+age+"岁了!");
    }

    public static void main(String[] args) {
        Demo1 test = new Demo1("张三",23);
        test.say();
    }
}

