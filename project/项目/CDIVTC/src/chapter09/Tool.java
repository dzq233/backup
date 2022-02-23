package chapter09;

import java.util.Collection;
import java.util.Iterator;

public class Tool {
	public static void info(Collection a) {
		Iterator it = a.iterator();
		while(it.hasNext()) {
			System.out.println(it.next()+" ");
		}
		
		System.out.println();
	}

}
