import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new LinkedList<>();
        int time = 0;
        int idx = 0;
        int total_weight = 0;
        while(idx<truck_weights.length || !bridge.isEmpty()) {
            time++;
            if(!bridge.isEmpty() && time - bridge.peek().getEnterTime() >= bridge_length) {
                total_weight -= bridge.poll().getWeight();
            }
            if(idx<truck_weights.length && total_weight + truck_weights[idx] <= weight && bridge.size() < bridge_length) {
                    bridge.offer(new Truck(truck_weights[idx], time));
                    total_weight += truck_weights[idx];
                    idx++;
            }
        }
        return time;
    }
    static class Truck {
        private int weight;
        private int enterTime;
        
        public Truck(int weight, int enterTime) {
            this.weight = weight;
            this.enterTime = enterTime;
        }
        public int getWeight() {
            return this.weight;
        }
        public int getEnterTime() {
            return this.enterTime;
        }
    }
}