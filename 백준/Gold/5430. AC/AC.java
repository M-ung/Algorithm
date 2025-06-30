import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        for(int i=0; i<t; i++) {
            String command = br.readLine();
            char[] commands = command.toCharArray();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String array = br.readLine();

            Deque<Integer> newArray = extract(array);
            String direct = "front";
            boolean check = true;

            for(char c : commands) {
                if(newArray.isEmpty() && c == 'D') {
                    check = false;
                    break;
                }
                switch (c) {
                    case 'R' :
                        direct = direct.equals("front") ? "back" : "front";
                        break;
                    case  'D' :
                        if (direct.equals("front")) {
                            newArray.removeFirst();
                        } else if (direct.equals("back")) {
                            newArray.removeLast();
                        }
                        break;
                }
            }
            if (!check) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");

                int size = newArray.size();
                if (direct.equals("front")) {
                    for (int l = 0; l < size; l++) {
                        sb.append(newArray.pollFirst());
                        if (l != size - 1) {
                            sb.append(",");
                        }
                    }
                } else {
                    for (int l = 0; l < size; l++) {
                        sb.append(newArray.pollLast());
                        if (l != size - 1) {
                            sb.append(",");
                        }
                    }
                }

                sb.append("]");
                System.out.println(sb);
            }
        }
    }

    private static Deque<Integer> extract(String array) {
        String newArray = array.replaceAll("[\\[\\]]", "");
        Deque<Integer> result = new LinkedList<>();
        if (!newArray.isBlank()) {
            for (String s : newArray.split(",")) {
                result.add(Integer.parseInt(s));
            }
        }
        return result;
    }
}