package person;
class SanWei{
    int b;//胸围
    int w;//腰围
    int h;//臀围
}
public class People5 {
    void speak(int age,SanWei sanwei){
        System.out.println("我今年"+age+"岁了,"+"我的三维是:"+sanwei.b+","+sanwei.w+","+sanwei.h);
        age = 24;
        sanwei.b = 80;
    }

    public static void main(String[] args) {
        People5 xiaoli = new People5();
        int age = 23;
        SanWei sanwei= new SanWei();
        sanwei.b=90;
        sanwei.w=60;
        sanwei.h=90;
        //age传递的是值，sanwei传递的是引用（地址），c里叫指针
        xiaoli.speak(age,sanwei);
        System.out.println(age);
    }
}
