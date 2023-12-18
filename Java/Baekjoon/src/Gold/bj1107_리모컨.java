package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1107_리모컨 {
    static String N;
    static int index, result;
    static boolean[] ban = new boolean[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        result = Math.abs(100 - Integer.parseInt(N));
        int M = Integer.parseInt(br.readLine());
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                ban[Integer.parseInt(st.nextToken())] = true;
            }
        }

        click(0, new StringBuilder());
        System.out.println(result);
    }

    static void click(int index, StringBuilder tgt) {
        if (index == N.length() || (index == N.length() - 1 && index > 0) || index == N.length() + 1) {
            int cnt = 0;
            for (int i = 0; i < index; i++) {
                if (tgt.charAt(i) == '0') {
                    if (i != index - 1) {
                        cnt++;
                    }
                } else {
                    break;
                }
            }
            result = Math.min(result, Math.abs(Integer.parseInt(tgt.toString()) - Integer.parseInt(N)) + index - cnt);
        }
        if (N.length() + 1 == index) return;
        for (int i = 0; i < 10; i++) {
            if (ban[i]) continue;
            tgt.append(Character.forDigit(i, 10));
            click(index + 1, tgt);
            tgt.deleteCharAt(index);
        }
    }
}
// 다른 풀이
/*
public class Main {
	static boolean available[] = new boolean[10];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < 10; i++) {
			available[i] = true;
		}

		if (M != 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				available[Integer.parseInt(st.nextToken())] = false;
			}
		}

		int res = Math.abs(N - 100);

		for (int i = 0; i <= 1000000; i++) {
			int cnt = check(i);
			if (cnt > 0) {
				res = Math.min(res, Math.abs(i - N) + cnt);
			}
		}
		System.out.println(res);
	}

	// 사용 가능한지, 사용 가능하면 몇 번 눌러야하는지
	private static int check(int num) {
		if(num == 0) {
			if(available[0])
				return 1;
			else
				return 0;
		}

		int cnt = 0;
		while (num > 0) {
			// 사용 불가능이면 끝내기
			if (!available[num % 10])
				return 0;
			num /= 10;
			cnt++;
		}

		return cnt;
	}

}

 */