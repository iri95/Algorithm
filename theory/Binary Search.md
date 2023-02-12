# 이분 탐색 (Binary Search)

- 이분 탐색을 수행하기 위해서는 기본적으로 정렬이 되어있어야 한다.

- 특정 값을 찾을 떄 절반씩 나누어 값을 찾는다는 것이 핵심적인 아이디어

- 분할 정복(Divide Conquer) 알고리즘의 한 예

- 시간 복잡도 : logN 



> **변수**

- Start = 0

- End = 배열의 길이 -1

- Mid = (Start + End) / 2



> **대표적 아이디어**

1. 찾고자 하는 값이 배열(Mid)의 값보다 큰 경우, Start 값을 증가
   
   - Start = Mid + 1

2. 찾고자 하는 값이 배열(Mid)의 값보다 작은 경우, End 값을 감소
   
   - End = Mid - 1

3. 찾고자 하는 값이 배열(Mid)에 위치한 경우, Mid를 반환
   
   - return Mid



문제

```java
package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1920 {
	static int N, M;
	static int[] A, B;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		B = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		for (int m : B) {
			int l = 0;
			int r = N-1;
			int count = 0;
			while(l<=r) {
				int a = (l+r)/2;
				if(A[a] == m) {
					count = 1;
					break;
				}
				if(A[a] < m) {
					l = a + 1;
				}else {
					r = a -1;
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
	}
}


```



```java
package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1072 {
	static long X, Y, Z, start, end, mid, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		Z = (Y * 100) / X;
		start = 0;
		end = 1000000000;
		if(Z >= 99) {
			System.out.println(-1);
			return;
		}
		while(start <= end) {
			mid = (start + end) / 2;
			if(((Y+mid) * 100) / (X + mid) != Z) {
				ans = mid;
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		System.out.println(ans);

	}

}

```










