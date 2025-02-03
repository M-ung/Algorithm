class Solution {
    int[][] ans;
    int idx = 0;
    public int[][] solution(int n) {
        ans = new int[(int) Math.pow(2,n)-1][2];
        
        hanoi(n,1,3);
        return ans;
    }
    
    void hanoi(int n, int from, int to){
        if(n == 1){
            ans[idx][0] = from;
            ans[idx][1] = to;
            idx++;
            return;
        }
        int o = 6-from-to;
        
        hanoi(n-1, from, o);
        hanoi(1, from, to);
        hanoi(n-1, o, to);
        
    }
}