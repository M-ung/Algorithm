import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<Node> queue = new java.util.LinkedList<>();
            for(int j=0; j<n; j++) {
                queue.add(new Node(j, Integer.parseInt(st.nextToken())));
            }
            int printOrder = 0;
            while(true) {
                Node node = queue.poll();
                boolean hasHigher = false;
                for(Node qNode : queue) {
                    if(qNode.value > node.value) {
                        hasHigher = true;
                        break;
                    }
                }
                if(hasHigher) {
                    queue.add(node);
                } else {
                    printOrder++;
                    if(node.index == m) {
                        System.out.println(printOrder);
                        break;
                    }
                }
            }
        }
    }
    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
