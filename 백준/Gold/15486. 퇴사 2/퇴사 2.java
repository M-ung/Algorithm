import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Schedule> schedules = new ArrayList<>();
        int[] dp = new int[n+1];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            schedules.add(new Schedule(time, money));
        }

        for(int i=0; i<n; i++) {
            int time = schedules.get(i).getTime();
            int money = schedules.get(i).getMoney();
            dp[i+1] = Math.max(dp[i], dp[i+1]);

            if(i+time <= n) {
                dp[i+time] = Math.max(dp[i+time], dp[i] + money);
            }
        }
        System.out.println(dp[n]);
    }

    static class Schedule {
        private int time;
        private int money;
        public Schedule(int time, int money) {
            this.time = time;
            this.money = money;
        }
        public int getTime() {
            return time;
        }
        public int getMoney() {
            return money;
        }
    }
}
