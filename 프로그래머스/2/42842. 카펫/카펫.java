class Solution {
    public int[] solution(int brown, int yellow) {
        // (width - 2) * (height - 2) = yellow
        int len = brown + yellow;
        int width = 0;
        int height = 0;
        int a = 0;
        int b = 0;
        for(int i = 1; i < len; i++) {
            if(len % i == 0) {
                a = i;
                b = len/i;
                if((a-2) * (b-2) == yellow) break;
            }
        }
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        return new int[] {max, min};
    }
}