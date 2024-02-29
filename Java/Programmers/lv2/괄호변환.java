package lv2;

public class 괄호변환 {
    public static String solution(String p) {
        if (p.isEmpty() || isRight(p)) return p;
        return recursion(p);
    }

    public static boolean isRight(String str) {
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt1++;
            } else {
                cnt2++;
            }
            if (cnt1 < cnt2) return false;
        }
        return true;
    }

    public static String recursion(String str) {
        if (str.isEmpty()) return "";
        int cnt1 = 0;
        int cnt2 = 0;
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                u.append('(');
                cnt1++;
            } else {
                u.append(')');
                cnt2++;
            }
            if (cnt1 == cnt2) {
                for (int j = i + 1; j < str.length(); j++) {
                    v.append(str.charAt(j));
                }
                break;
            }
        }
        if (isRight(u.toString())) return u + recursion(v.toString());
        else {
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') u.setCharAt(i, ')');
                else u.setCharAt(i,'(');
            }
            return "(" + recursion(v.toString()) + ")" + u.substring(1, u.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
    }

}
