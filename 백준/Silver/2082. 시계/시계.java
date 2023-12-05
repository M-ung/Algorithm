import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		//digit 저장.
		char []zero =  "####.##.##.####".toCharArray();
		char []one =   "..#..#..#..#..#".toCharArray();
		char []two =   "###..#####..###".toCharArray();
		char []three = "###..####..####".toCharArray();
		char []four =  "#.##.####..#..#".toCharArray();
		char []five =  "####..###..####".toCharArray();
		char []six =   "####..####.####".toCharArray();
		char []seven = "###..#..#..#..#".toCharArray();
		char []eight = "####.#####.####".toCharArray();
		char []nine =  "####.####..####".toCharArray();
		
		char [][]digit = new char[][]{
				zero, one, two, three, four, five, six, seven, eight, nine
		};
		
		//입력받기.
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String input[] = new String[] {"", "", "", ""};
		
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String temp1= st.nextToken();
			String temp2= st.nextToken();
			String temp3= st.nextToken();
			String temp4= st.nextToken();
			input[0] += temp1;
			input[1] += temp2;
			input[2] += temp3;
			input[3] += temp4;			
		}

		char [][] myClock = new char[4][15];
		for(int i=0;i<4;i++) {
			myClock[i] = input[i].toCharArray();
		}
		
		
		int i, j, k;
		for(i=0;i<4;i++) {
			for(j=0;j<10;j++) {
				for(k=0;k<15;k++) {
					if (myClock[i][k]=='#' && digit[j][k]=='.') break;				
				}
				
				if(k==15) {
					System.out.print(j);
					break;}
			}
			if(i==1) System.out.print(":");
		}

	}
}