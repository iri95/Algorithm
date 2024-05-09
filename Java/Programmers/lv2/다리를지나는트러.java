package lv2;

import java.util.ArrayDeque;
import java.util.Queue;

public class 다리를지나는트러 {
    static class Truck{
        int time;
        int weight;
        public Truck(int time, int weight){
            this.time = time;
            this.weight = weight;
        }
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Queue<Truck> queue = new ArrayDeque<>();
        int weightSum = 0;
        int N = truck_weights.length;
        int index = 0;
        int size = 0;
        while(true){
            while(index < N && size < bridge_length){
                if(weightSum + truck_weights[index] > weight) break;
                queue.add(new Truck(answer++, truck_weights[index]));
                weightSum += truck_weights[index++];
                size++;
            }
            if(queue.isEmpty()) break;
            Truck truck = queue.poll();
            size--;
            weightSum -= truck.weight;
            answer = Math.max(answer , truck.time + bridge_length); //
        }

        return answer;
    }
}
