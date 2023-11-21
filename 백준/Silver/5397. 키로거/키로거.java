import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();
            String str = br.readLine();

            for(int j=0; j<str.length(); j++) {
                char command = str.charAt(j);
                switch(command) {
                    case '<' :
                        if(iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;
                    case '>' :
                        if(iter.hasNext()) {
                            iter.next();
                        }
                        break;
                    case '-' :
                        if(iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default :
                        iter.add(command);
                }
            }
            for(char c : list) {
                bw.write(c);
            }
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}