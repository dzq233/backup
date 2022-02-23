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
		//��ʹ�÷���ǰ��Ҫ���Ǹ���ķ�������Ҫ������Ӧ��Ķ���
		//���뽫��д��������
		Student s = new Student();
		s.eat();
		Teacher t = new Teacher();
		t.eat();
		
		System.out.println("-----ʹ�÷��䣬��ȡ�����ļ�-----");
		//����Properies��Ķ���ʵ����
		Properties p = new Properties();
		//�����������ļ�
		FileReader r = new FileReader("class.txt");
		p.load(r);
		//��Properties���л�ȡ����
		String className = p.getProperty("className");//��ȡ����
		String mName = p.getProperty("mName");//��ȡ������
		
		//��ȡ����ֽ����ļ�
		Class c = Class.forName(className);
		Constructor con = c.getConstructor();
		Object obj = con.newInstance();
		Method m = c.getMethod(mName);
		m.invoke(obj);
		
	}
}
