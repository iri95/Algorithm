package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < skill.length(); i++) {
            list.add(skill.charAt(i));
        }

        for (int i = 0; i < skill_trees.length; i++) {
            boolean[] visit = new boolean[list.size()];
            boolean result = true;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                if (list.contains(skill_trees[i].charAt(j))) {
                    int index = list.indexOf(skill_trees[i].charAt(j));
                    for (int k = 0; k < index; k++) {
                        if (!visit[k]) {
                            result = false;
                            break;
                        }
                    }
                    visit[index] = true;
                }
                if (!result) break;
            }
            if (result) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution2("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    public static int solution2(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        //ArrayList<String> skillTrees = new ArrayList<String>();
        Iterator<String> it = skillTrees.iterator();
        System.out.println(it.next().replaceAll("[^" + skill + "]", ""));
        while (it.hasNext()) {
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }
}
/*
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        //ArrayList<String> skillTrees = new ArrayList<String>();
        Iterator<String> it = skillTrees.iterator();

        while (it.hasNext()) {
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }
}
 */