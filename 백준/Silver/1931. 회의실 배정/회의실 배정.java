import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Room> pq = new PriorityQueue<>(new Comparator<Room>() {
            @Override
            public int compare(Room r1, Room r2) {
                if(r1.end == r2.end) {
                    return r1.start - r2.start;
                }
                return r1.end - r2.end;
            }
        });

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Room room = new Room(start, end);
            pq.add(room);
        }

        int endTime = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Room room = pq.poll();
            if (room.start >= endTime) {
                endTime = room.end;
                count++;
            }
        }
        System.out.println(count);
    }

    public static class Room {
        private int start;
        private int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
