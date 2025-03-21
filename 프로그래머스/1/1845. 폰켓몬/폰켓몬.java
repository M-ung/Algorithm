import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();

        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        
        int mid = nums.length/2;
        
        if(set.size() < mid) {
            return set.size();
        } else {
            return mid;
        }
    }
}