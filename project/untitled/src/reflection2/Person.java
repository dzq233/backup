package reflection2;

public class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(){

    }
    public void show(){
        System.out.println("你好，我是一个人");
    }
    private String showNation(String nation){
        System.out.println("我的国籍是:"+ nation);
        return nation;
    }
}
