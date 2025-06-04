
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static Picture[] pictures;
    static int[] votes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        pictures = new Picture[n];
        votes = new int[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            votes[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            int vote = votes[i];
            boolean found = false;
            for (int j = 0; j < count; j++) {
                if (pictures[j].number == vote) {
                    pictures[j].addVote();
                    found = true;
                    break;
                }
            }

            if (!found) {
                if (count < n) {
                    pictures[count++] = new Picture(vote, i);
                } else {
                    int minIndex = 0;
                    for (int j = 1; j < count; j++) {
                        if (pictures[j].votes < pictures[minIndex].votes || (pictures[j].votes == pictures[minIndex].votes && pictures[j].timestamp < pictures[minIndex].timestamp)) {
                            minIndex = j;
                        }
                    }
                    pictures[minIndex] = new Picture(vote, i);
                }
            }
        }

        Arrays.sort(pictures, 0, count, Comparator.comparingInt(p -> p.number));
        for (int i = 0; i < count; i++) {
            System.out.print(pictures[i].number + " ");
        }
    }

    static class Picture {
        int number;
        int votes;
        int timestamp;

        public Picture(int number, int timestamp) {
            this.number = number;
            this.votes = 1;
            this.timestamp = timestamp;
        }

        public void addVote() {
            this.votes++;
        }
    }
}