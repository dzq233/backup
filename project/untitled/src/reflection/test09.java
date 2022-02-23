package reflection;
//动态的创建对象，通过反射
public class test09 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //获得class对象
        Class c1 = Class.forName("reflection.Test01.User");

        //构造一个对象
        //User user = (User)c1.newInstance();
        //System.out.println(user);
    }
}
