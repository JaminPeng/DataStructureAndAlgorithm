package DP;

import java.util.LinkedList;
import java.util.Queue;

public class SumMax {

    public static void main(String[] args) {
        int arr[] = {6, 2, 4, 1, 7, 8, 3};
        int result = dp_opt(arr);
        System.out.println(result);
        Queue queue = new LinkedList<>();
        System.out.println(dc_opt(arr,6));
    }

    public static int dp_opt(int[] arr) {
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for(int i=2; i<arr.length; i++) {
            int a = opt[i-2] + arr[i];
            int b = opt[i-1];
            opt[i] = Math.max(a, b);
        }
        return opt[arr.length-1];
    }

    public static int dc_opt(int[] arr, int i) {
        if(i == 0) {
            return arr[0];
        }
        if(i == 1) {
            return Math.max(arr[0], arr[1]);
        }
        int a = dc_opt(arr, i-2) + arr[i];
        int b = dc_opt(arr, i-1);
        return Math.max(a,b);

    }

}
