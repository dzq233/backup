import java.util.ArrayList;

public class Test01 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("234");
        list.add("五六七");
        list.add("789");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
        System.out.println("=================================");
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println(list);
    }
}
