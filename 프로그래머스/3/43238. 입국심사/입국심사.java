import java.util.*;

class Solution {
    public static int max;
    public static long low;
    public static long high;
    public static long mid;
    public long solution(int n, int[] times) {
        max = getMax(n, times);
        low = 1;
        high = (long) max * n;
        
        mid = (low + high) / 2;
        while(low <= high) {
            mid = (low + high) / 2;
            
            long sum = 0;
            for(int i=0; i<times.length; i++) {
                long count = (mid/times[i]);
                sum += count;
            }
            if (sum < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    private int getMax(int n, int[] times) {
        int max = 0;
        for(int i=0; i<times.length; i++) {
            if(times[i] > max) max = times[i];
        }
        return max;
    }
}