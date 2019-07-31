package sort.array.three;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] a = {50, 3, 542, 745, 2014, 154, 63, 616};
        radixSort(a);
        System.out.println(Arrays.toString(a));

    }
    public static void radixSort(int[] a) {
        int max = getMax(a);
        int exp;
        for (exp =1; max/exp >0; exp *=10) {
            countSort(a, exp);
        }
    }
    private static int getMax(int[] a) {
        int max = a[0];

        for(int i=1; i<a.length; i++) {
            if(max < a[i]) {
                max = a[i];
            }
        }

        return max;
    }

    private static void countSort(int[] a, int exp) {
        int[] output = new int[a.length]; // 存储"被排序数据"的临时数组
        int[] buckets = new int[10]; //所有的自然数

        // 出现的次数累加
        for(int i=0; i< a.length; i++) {
            buckets[ (a[i]/exp)%10 ]++;
        }
        // 将 数组数据依次从前往后累加
        for(int j=1; j< 10; j++) {
            buckets[j] += buckets[j-1];
        }

        //将结果输出到 output中
        for(int m =a.length-1; m>=0; m--) {
            output[buckets[(a[m]/exp)%10]-1] = a[m];
            buckets[(a[m]/exp)%10] --;
        }

        for(int n = 0; n< output.length; n++) {
            a[n] = output[n];
        }

        output = null;
        buckets = null;
    }
}
