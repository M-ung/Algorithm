import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> ins = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        Car[] cars = new Car[n];

        for(int i = 0; i < n; i++) {
            ins.put(br.readLine(), i);
        }

        for(int i = 0; i < n; i++) {
            String name = br.readLine();
            cars[i] = new Car(name, ins.get(name));
        }

        int last = cars[cars.length-1].rank;
        int count = 0;
        for(int i = cars.length-1; i >= 0; i--) {
            Car car = cars[i];
            if(car.rank > last) {
                count++;
            }
             else {
                 last = car.rank;
            }
        }
        System.out.println(count);
    }

    public static class Car {
        String name;
        int rank;
        public Car(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }
    }
}