package person;

public class People {
    String name;
    int age;

    public void speak() {
        System.out.println("我叫" + name + "，我今年" + age + "岁了");
    }

    public static void main(String[] args) {
        People zhangsan = new People();
        zhangsan.name = "张三";
        zhangsan.age = 23;
        zhangsan.speak();
    }
}
