package sort.array.three;

import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {
        int[] a = {2,3,0,23,21,2,5,9,11};
        System.out.println(Arrays.toString(a));
        countSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    public static void countSort(int[] a, int n) {
        if(n <= 1) {
            return;
        }
        //查找数组中数据的范围
        int max = a[0];
        for(int i=1; i< a.length; i++) {
            if(max < a[i]) {
                max = a[i];
            }
        }

        // 申请计数数组,下标为[0, max]
        int[] c = new int[max +1];
        // 初始化
        for(int i=0; i<=max; i++) {
            c[i] = 0;
        }
        // 将a数组的值作为c数组的index, c数组的值是a数组值的累积count
        for(int i=0; i< n; i++) {
            //计算每个元素的个数，放入c中
            c[a[i]] ++;
        }
        //依次累积,c数组的key为a数组的值，value为依次数组元素值的向前累积
        for(int i=1; i<= max; i++) {
            c[i] = c[i-1] + c[i];
        }
        // 临时数组，存储排序后的结果
        int[] r = new int[n];

        //计算排序的关键步骤，比较难理解
        for(int i=n-1; i>=0; i--) {
            // 拿到以a数组对应值为key 求出 c数组中的对应的value(index)
            int index = c[a[i]]-1;
            // 这个index作为r数组的key，value是a数组的值
            r[index] = a[i];
            // 累积的值要递减
            c[a[i]]--;
        }

        //将结果拷贝到a数组
        for(int i=0; i<n; i++) {
            a[i] = r[i];
        }
    }
}
