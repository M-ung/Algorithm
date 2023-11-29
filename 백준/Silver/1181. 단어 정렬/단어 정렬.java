import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [] str = new String[n];
		for(int i=0; i<n;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			str[i]=s;
		}
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(str));

        String[] resultArr = hashSet.toArray(new String[0]);
		for(int i=0; i<resultArr.length; i++)
		{
			for(int j=0; j<resultArr.length-i-1; j++)
			{
				if(resultArr[j].length() > resultArr[j+1].length())
				{
					String temp = resultArr[j+1];
					resultArr[j+1] = resultArr[j];
					resultArr[j]=temp;
				}
				else if(resultArr[j].length() == resultArr[j+1].length())
				{
					if(resultArr[j].compareTo(resultArr[j+1])>0)
					{
						String temp = resultArr[j];
						resultArr[j] = resultArr[j+1];
						resultArr[j+1] = temp;
					}
				}
			}
		}
		for(int i=0; i<resultArr.length; i++)
		{
			System.out.println(resultArr[i]);
		}
		
	}
}