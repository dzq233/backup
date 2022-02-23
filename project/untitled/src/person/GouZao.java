package person;

public class GouZao {
    String name;
    int age;
    //默认构造方法
    GouZao(){
        System.out.println();
    }
    //有参数的构造方法
    GouZao(String name2,int age2){
        System.out.println();
        name = name2;
        age = age2;
        System.out.println("有参数的构造方法");
    }
    public void say(){
        System.out.println("我叫"+name+",我今年"+age+"岁了");
    }
    public static void main(String[] args) {
        GouZao people2 = new GouZao("zhangsan",23);
        people2.say();
    }
}
