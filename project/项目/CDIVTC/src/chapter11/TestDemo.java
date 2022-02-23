package chapter11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//不使用反射前，要用那个类的方法，则要创建对应类的对象
		//必须将类写到代码中
		Student s = new Student();
		s.eat();
		Teacher t = new Teacher();
		t.eat();
		
		System.out.println("-----使用反射，读取配置文件-----");
		//创建Properies类的对象实例化
		Properties p = new Properties();
		//创建输入六文件
		FileReader r = new FileReader("class.txt");
		p.load(r);
		//从Properties类中获取数据
		String className = p.getProperty("className");//获取类命
		String mName = p.getProperty("mName");//获取方法名
		
		//获取类的字节码文件
		Class c = Class.forName(className);
		Constructor con = c.getConstructor();
		Object obj = con.newInstance();
		Method m = c.getMethod(mName);
		m.invoke(obj);
		
	}
}
