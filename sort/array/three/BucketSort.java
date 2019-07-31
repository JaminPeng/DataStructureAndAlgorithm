package sort.array.three;

import java.util.Arrays;

public class BucketSort {

    public static void main(String[] args) {
        int[] a = {2,4,15,12,19,7,3,4,12};
        System.out.println(Arrays.toString(a));
        new BucketSort().bucketSort(a);

        String abc = "005";
        System.out.println(abc.toUpperCase());

    }
    //一个简单的 Bucket sort
    public void bucketSort(int[] a) {

        //限定输入的数据是0～20 之间, 我们定义21个元素
        int[] array = new int[21];
        for(int i=0;i<array.length; i++) {
            array[i] = 0;
        }
        for(int j=0; j< a.length; j++) {
            array[a[j]]++;
        }
        int p = 0;
        // 数据输出
        for(int m=0; m< array.length; m++) {
            if(array[m]>0) {
                for(int n=0; n< array[m]; n++) {
                    a[p++] = m;
                }
            }
        }

        System.out.println(Arrays.toString(a));
    }
}
