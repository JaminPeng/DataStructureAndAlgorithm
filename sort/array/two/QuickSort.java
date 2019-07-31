package sort.array.two;

public class QuickSort {


    public int partition(int[] a, int p, int r) {
        int i=p;
        int pivot = a[r];
        for(int j=p;j<r;j++) {
            if(a[j] >= pivot) {
                swap(i, j, a);
                i = i+1;
            }
        }
        swap(i,r, a);
        return i;
    }

    public  int findMaxVauleOfK(int[] a, int k) {
        if(a == null || a.length < k) {
            return -1;
        }
        int result = partition(a, 0, a.length-1);
        while (result+1 != k) {
            if(result+1 < k) {
                result = partition(a, result+1, a.length-1);
            } else {
                result = partition(a, 0, result-1);
            }
        }
        return a[result];
    }
    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[]a = {3,5,8,4,0,12,7};
//        int[] a =  {1,1,2};

//        int result = sort.partition(a, 0,2);
//        System.out.println(result);
//        sort.print(a);

        int k = sort.findMaxVauleOfK(a, 4);
        System.out.println(k);

    }


    private void swap(int i, int j, int a[]) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private void print(int[] a) {
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+",");
        }
    }

}
