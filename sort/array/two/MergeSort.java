package sort.array.two;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {8,3,2,1,9,5,4,0,2};
        MergeSort sort = new MergeSort();
        sort.mergeSort(a, a.length);
        System.out.println(Arrays.toString(a));
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
}
