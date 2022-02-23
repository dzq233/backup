package study;

public class Day02 {
    public static void main(String[] args){
        //一维数组的声明与初始化
        int num;//声明
        num = 10;//初始化
        int id = 1001;//声明与初始化
        int[] ids;//声明
        //1.1静态初始化
        ids = new int[]{1001,1002,1003,1004};
        //1.2动态初始化
        String[] names = new String[5];
        //错误的写法
        //int[] arr1 = new int[];
        //int[] arr2 = new int[5];
        //int[] arr3 = new int[3]{1,2,3};

            //总结：数组一旦初始化完成，其长度就确定了
    }
}
