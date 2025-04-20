package lv3;

import java.util.*;

public class 선입선출스케줄링 {
    public int solution(int n, int[] cores) {
        if (n <= cores.length)
            return n;

        int s = 0;
        int e = 500_000_001;
        while (s < e) {
            int mid = (s + e) / 2;
            long sum = cores.length;

            for (int core : cores)
                sum += mid / core;

            if (sum >= n)
                e = mid;
            else
                s = mid + 1;
        }

        for (int core : cores)
            n -= (e - 1) / core + 1;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < cores.length; i++)
            if (e % cores[i] == 0)
                list.add(i + 1);

        return list.get(n - 1);
    }
}
