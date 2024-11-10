package lv3;

import java.util.*;

public class 다단계칫솔판매 {

    static Map<String, List<String>> map = new HashMap<>();
    static Map<String, List<Integer>> sell = new HashMap<>();
    static Map<String, Integer> cost = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int N = enroll.length;
        int[] answer = new int[N];
        map.put("-", new ArrayList<>());
        cost.put("-", 0);

        for (int i = 0; i < N; i++) {
            cost.put(enroll[i], 0);
            if (!map.containsKey(referral[i])) map.put(referral[i], new ArrayList<>());
            map.get(referral[i]).add(enroll[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            if (!sell.containsKey(seller[i])) sell.put(seller[i], new ArrayList<>());
            sell.get(seller[i]).add(amount[i]);
        }

        sol("-");

        for (int i = 0; i < N; i++)
            answer[i] = cost.get(enroll[i]);

        return answer;
    }

    private static List<Integer> sol(String name) {
        List<Integer> list = new ArrayList<>();

        if (map.containsKey(name)) {
            for (String n : map.get(name)) {
                for (int c : sol(n)) {
                    if (c >= 10) {
                        list.add(c / 10);
                        cost.put(name, cost.get(name) + c - c / 10);
                    } else cost.put(name, cost.get(name) + c);
                }
            }
        }

        if (sell.containsKey(name)) {
            for (int s : sell.get(name)) {
                list.add(s * 10);
                cost.put(name, cost.get(name) + s * 90);
            }
        }

        return list;
    }
}
/*
import java.util.HashMap;

class Person {
    String name;
    Person parent;
    int money;

    public Person(String name, Person parent, int money) {
        this.name = name;
        this.parent = parent;
        this.money = money;
    }

    void getReward(int i) {
        int moneyToParent = (int) (i * 0.1);
        this.money += i - moneyToParent;
        if (this.parent != null)
            this.parent.getReward(moneyToParent);
    }
}

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Person> personHashMap = new HashMap<>();
        for (String name : enroll)
            personHashMap.put(name, new Person(name, null, 0));

        for (int i = 0; i < enroll.length; i++) {
            if (referral[i].equals("-"))
                continue;
            personHashMap.get(enroll[i]).parent = personHashMap.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++)
            personHashMap.get(seller[i]).getReward(amount[i] * 100);

        int[] result = new int[enroll.length];

        for (int i = 0; i < result.length; i++)
            result[i] = personHashMap.get(enroll[i]).money;

        return result;
    }
}
 */