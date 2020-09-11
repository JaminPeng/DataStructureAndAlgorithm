package DP;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConcurrentUsersWithTimeRanges {

    public static void main(String[] args) throws ParseException {
        List<String> dataList = new ArrayList<>();
        dataList.add("User1,1130,1230");
        dataList.add("User2,1135,1330");
        dataList.add("User3,1300,1525");
        dataList.add("User1,1430,1525");
        System.out.println(Arrays.toString(findPeak(dataList)));
    }


    public static long[] findPeak(List<String> login) throws ParseException {

        int n = login.size();
        if (n <= 1) return null;
        int ans = 1;
        long[][] a = new long[n][2];
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        for (int i = 0; i < n; i++) {

            String[] arr = login.get(i).split(",");
            a[i] = new long[]{Long.parseLong(arr[1]), Long.parseLong(arr[2])};

        }

        Arrays.sort(a, (x, y) -> (int) (y[0] == y[1] ? x[0] - x[1] : y[0] - y[1]));
        long startAns = 0, endAns = 0;

        for (int i = 0; i < n-1; i++) {

//            int j = Collections.binarySearch(a, i, n);
            int j = i+1;
            long start = a[j][0];
            while (j < n && a[j][0] <= a[i][1]) j++;
            long end = a[i][1];

            if (j != -1 && j-i+1 > ans) {

                ans = j-i+1;
                startAns = start;
                endAns = end;
            }
        }

        return new long[]{ans, startAns, endAns};
    }
}
