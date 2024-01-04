package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class bj1181_단어정렬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String a = br.readLine();
			boolean is = false;
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j).equals(a)) {
					is = true;
				}
			}
			if(is)continue;
			list.add(a);
		}
		Collections.sort(list);
		for (int j = 1; j <= 50; j++) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).length() == j) {
					System.out.println(list.get(i));
				}
			}
		}
	}
}
/* 좋은 코드
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i<N; i++) {
            arr[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr, ((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length()-o2.length();
        }));

        for (int i = 0; i<N; i++) {
            if (i != 0 && arr[i].equals(arr[i-1])) {
                continue;
            }
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
 */
