package offer;

public class Test {
	public static void main(String[] args) {
		String[] news = new String[] {
				"abdad","adgdasg"
		};
		for(String i:news) {
			if(i.length() > 5) {
				
			System.out.println(i.substring(0,5)+"...");
			}
			else {
				System.out.println(i);
			}
		}
	}

}
