import java.util.*;
class Solution {
    public int solution(int[] citations) {
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i< citations.length; i++) {
            arr.add(citations[i]);
        }
        Collections.sort(arr);
        int hIndex = 0;
        for(int i=0; i<arr.size(); i++) {
			int h = arr.size() - i; 
			
			if(arr.get(i) >= h) {
				hIndex = h;
				break;
			}
        }
        return hIndex;
    }
}
// 0 1 3 5 6