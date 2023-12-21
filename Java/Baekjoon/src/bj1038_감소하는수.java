import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj1038_감소하는수 {
    static List<Long> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N <= 10)
            System.out.print(N);
        else if (N >= 1023)
            System.out.print(-1);
        else {
            list = new ArrayList<>();
            for (long i = 0; i < 10; i++) list.add(i);
            for (long i = 10; i < 100; i++) plus(i);
            for (long i = 210; i < 1000; i++) plus(i);
            for (long i = 3210; i < 10000; i++) plus(i);
            for (long i = 43210; i < 100000; i++) plus(i);
            for (long i = 543210; i < 1000000; i++) plus(i);
            for (long i = 6543210; i < 10000000; i++) plus(i);
            for (long i = 76543210; i < 100000000; i++) plus(i);
            for (long i = 876543210; i < 1000000000; i++) plus(i);
            list.add(9876543210l);
            System.out.println(N > list.size() - 1 ? -1 : list.get(N));
        }
    }

    static void plus(long i) {
        long k = i;
        boolean t = false;
        while (k / 10 > 0) {
            long a = k % 10;
            long b = (k / 10) % 10;
            if (a >= b) {
                t = false;
                return;
            } else {
                k = k / 10;
                t = true;
            }
        }
        if (t) {
            list.add(i);
        }
    }
}
// 다른 풀이
/*

import java.io.*;

import java.util.*;

public class Main {

	static int res = 0;

	static int[] dp;
	static int[][] flow;
	static int[] arr;

	static String str;
	static List<Long> list = new ArrayList<>();

	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, k;
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;

		if (n <= 10)
			System.out.print(n);
		else if (n >= 1023)
			System.out.print(-1);
		else {
			for (int i = 0; i < 10; i++)
				solve(i, 1);
			Collections.sort(list);
			System.out.print(list.get(n));
		}
	}

	public static void solve(long num, int cnt) {
		if (cnt > 10)
			return;

		list.add((long) num);

		for (int i = 0; i < num % 10; i++) {
			solve(num * 10 + i, cnt+1);
		}
	}
}
 */