package sort.array.two;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {8,3,2,1,9,5,4,0,2};
//        MergeSort sort = new MergeSort();
//        sort.mergeSort(a, a.length);
//        System.out.println(Arrays.toString(a));
        System.out.print(Arrays.toString(MergeSort(a)));
    }
    public void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n-1);
    }

    public void mergeSortInternally(int[] a, int p, int r) {

        if(p >= r) {
            return;
        }
        int q = p + (r-p)/2;
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q+1, r);
        merge(a, p, q, r);
    }

    public void merge(int[] a, int p, int q, int r) {
        int[] tmp = new int[r-p+1];
        int i=p;
        int j=q+1;
        int k=0;
        while (i<=q && j<=r) {
            if(a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        int start = i;
        int end = q;
        if(j<=r) {
            start=j;
            end = r;
        }

        while (start <= end) {
            tmp[k++] = a[start++];
        }

        for(int m=0; m<= r-p; m++) {
            a[p+m] = tmp[m];
        }
    }

    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
}
