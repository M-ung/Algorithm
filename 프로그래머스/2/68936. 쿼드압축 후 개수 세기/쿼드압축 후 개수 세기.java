import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[] {count.zero, count.one};
    }
    
    private static class Count {
        public final int zero;
        public final int one;
        
        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
        
        public Count add(Count count) {
            return new Count(zero+count.zero, one+count.one);
        }
    }
    private Count count(int offX, int offY, int size, int[][] arr) {
    int h = size / 2;
    for (int x = offX; x<offX+size; x++) {
        for(int y = offY; y<offY+size; y++) {
            if(arr[y][x] != arr[offY][offX]) {
                return count(offX, offY, h, arr)
                    .add(count(offX + h, offY, h, arr))
                    .add(count(offX, offY + h, h, arr))
                    .add(count(offX + h, offY + h, h, arr));
            }
        }
    }
            
    if(arr[offY][offX] == 1) {
        return new Count(0,1);
    }
    return new Count(1,0);
    }
}