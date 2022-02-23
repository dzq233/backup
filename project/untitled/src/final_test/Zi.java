package final_test;

public class Zi extends Fu{
    @Override
    public void methodAbs(){

    }
    //错误写法，不能覆盖重写父类当中final的方法
    /*@Override
    public void method(){
        System.out.println("子类覆盖重写父类的方法");

        注意事项：
        对于类、方法来说，abstract关键字和final关键字不能同时使用，因为矛盾。
    }*/

}
