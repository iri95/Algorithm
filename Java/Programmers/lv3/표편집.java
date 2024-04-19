package lv3;

import java.util.Stack;
import java.util.StringTokenizer;

// TODO : LinkedList 직접 구현 정리
public class 표편집 {
    static Stack<Node> stack = new Stack<>();

    static class Node{
        int name;
        Node next;
        Node prev;

        public Node(int name){
            this.name = name;
        }
    }

    public static String solution(int n, int k, String[] cmd) {
        Node cur = init(n);
        for(int i = 0; i < k; i++){
            cur = cur.next;
        }

        for (String str : cmd) {
            StringTokenizer st = new StringTokenizer(str);
            String commend = st.nextToken();
            if (commend.equals("U")) {
                int count = Integer.parseInt(st.nextToken());
                cur = up(cur, count);
            } else if (commend.equals("D")) {
                int count = Integer.parseInt(st.nextToken());
                cur = down(cur, count);
            } else if (commend.equals("C")) {
                cur = delete(cur);
            } else {
                restore();
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("O".repeat(n));

        while(!stack.isEmpty()){
            Node node = stack.pop();
            sb.setCharAt(node.name, 'X');
        }

        return sb.toString();
    }

    static Node init(int n){
        Node start = new Node(-1);
        Node prev = start;
        Node cur = null;

        for(int i = 0; i < n; i++){
            cur = new Node(i);
            cur.prev = prev;
            prev.next = cur;
            prev = cur;
        }
        Node end = new Node(-1);
        cur.next = end;
        end.prev = cur;

        return start.next;
    }


    static Node up(Node cur, int count){
        for(int i = 0; i < count; i++){
            cur = cur.prev;
        }
        return cur;
    }

    static Node down(Node cur, int count){
        for(int i = 0; i < count; i++){
            cur = cur.next;
        }
        return cur;
    }

    static Node delete(Node cur){
        stack.push(cur);
        cur.next.prev = cur.prev;
        cur.prev.next = cur.next;
        if(cur.next.name == -1) return cur.prev;
        else return cur.next;
    }

    static void restore(){
        Node node = stack.pop();
        node.prev.next = node;
        node.next.prev = node;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 2,new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
        System.out.println(solution(8, 2,new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
    }
}