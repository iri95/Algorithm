package lv3;

import java.util.*;

public class n1카드게임 {
    public int solution(int coin, int[] cards) {
        int answer = 1;
        Set<Integer> hand = new HashSet<>();
        Set<Integer> non = new HashSet<>();
        int n = cards.length;
        for (int i = 0; i < n / 3; i++)
            hand.add(cards[i]);

        for (int i = n / 3; i < n; i += 2) {
            non.add(cards[i]);
            non.add(cards[i + 1]);

            // 손의 패로만 만드는 경우
            int a = 0, b = 0;
            for (int cur : hand) {
                int need = n - cur + 1;
                for (int value : hand) {
                    if (value == need) {
                        a = cur;
                        b = value;
                        break;
                    }
                }
                if (a != 0) break;
            }

            if (a != 0) {
                hand.remove(a);
                hand.remove(b);
                answer++;
                continue;
            }

            // 카드 한 장을 사는 경우
            if (coin >= 1) {
                for (int cur : hand) {
                    int need = n - cur + 1;
                    for (int value : non) {
                        if (value == need) {
                            a = cur;
                            b = value;
                            break;
                        }
                    }
                    if (a != 0) break;
                }

                if (a != 0) {
                    coin--;
                    hand.remove(a);
                    non.remove(b);
                    answer++;
                    continue;
                }
            }

            // 카드 두 장을 사는 경우
            if (coin >= 2) {
                for (int cur : non) {
                    int need = n - cur + 1;
                    for (int value : non) {
                        if (value == need) {
                            a = cur;
                            b = value;
                            break;
                        }
                    }
                    if (a != 0) break;
                }

                if (a != 0) {
                    coin -= 2;
                    non.remove(a);
                    non.remove(b);
                    answer++;
                    continue;
                }
            }

            break;
        }
        return answer;
    }
}
