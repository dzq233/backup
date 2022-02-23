package person;

public class People4 {
    //形参，入参,不固定参数
    int speak(String name,int age,String ...hobbies){
        System.out.println("我叫"+name+",我今年"+age+"岁了");
        System.out.print("我的爱好:");
        for (String hobby:hobbies){
            System.out.print(hobby+" ");
        }
        //获取爱好的长度
//        int totalHobbies = hobbies.length;
        return hobbies.length;
    }

    public static void main(String[] args) {
        People4 zhangsan = new People4();
        int h = zhangsan.speak("zh", 23, "杀人", "砍人", "男同","日批");
        int n = zhangsan.speak("张三",23,"唱歌","游泳","23");
        System.out.println("有"+n+"个爱好");

        System.out.println(h);
    }
}