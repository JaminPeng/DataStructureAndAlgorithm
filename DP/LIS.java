package DP;

import java.util.ArrayList;
import java.util.List;

public class LIS {

    public static void main(String[] args) {
        int[] input = {1,3,5,4,7};
        int result = findNumberOfLIS(input);

        System.out.println(result);
    }
    public static int findNumberOfLIS(int[] nums) {

        int[] len = new int[]{1,1,1,1,1};
        int[] cnt = new int[]{1,1,1,1,1};


        int res = 0;
        int mx = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if ((len[j] + 1)==len[i]) {
                        cnt[i]+=cnt[j];
                    }
                    else if ((len[j] + 1) > len[i]) {
                        cnt[i] = cnt[j];
                        len[i] = len[j] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (len[i] >= mx) {
                if (len[i] > mx) {
                    mx = len[i];
                    res = cnt[i];
                }
                else {
                    res += cnt[i];
                }
            }
        }
        return res;

    }
}
