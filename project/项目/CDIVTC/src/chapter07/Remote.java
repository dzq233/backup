package chapter07;
//接口中的abstract是隐式的
public interface Remote {
	String name = "遥控器";//接口中的常量，static final是隐式的
	void open();//接口中的抽象方法，public abstract是隐式的
}
