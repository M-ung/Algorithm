import java.util.*;

class Solution {
    public int[] solution(int n) {
        int height = n;
        int[][] triangles = new int[n+1][n+1];
        int cycle = n;
        int value = 1;
        int x = -1; int y =0; 
        while(cycle > 0) {
            // 내리막 (x좌표 1씩 증가)
            for(int i=0; i<cycle; i++) {
                x++;
                triangles[x][y] = value;
                value++;
            }
            cycle--;
            // 가로 (y좌표 1씩 증가)
            for(int j=0; j<cycle; j++) {
                y++; 
                triangles[x][y] = value;
                value++;
            }
            cycle--;
            // 대각선 (x, y 1씩 감소)
            for(int k=0; k<cycle; k++) {
                x--; y--; 
                triangles[x][y] = value;
                value++;
            }
            cycle--;
        }
        
        int total = (n*(n+1))/2;
        int[] answer = new int [total];
        int k=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(triangles[i][j] != 0) {
                    answer[k] = triangles[i][j];
                    k++;
                }
            }
        }
        return answer;
    }
}