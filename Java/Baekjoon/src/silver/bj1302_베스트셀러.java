package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class bj1302_베스트셀러 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        String result = "";
        int count = 0;
        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }else{
                map.put(key, 1);
            }
            if(map.get(key) >= count){
                if(map.get(key) == count){
                    if(key.compareTo(result) > 0){
                        continue;
                    }
                }
                count = map.get(key);
                result = key;
            }
        }
        System.out.println(result);

    }
}
