import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> par = new HashMap<>();
        for (String pa : participant) {
            if (par.containsKey(pa)) {
                par.put(pa, par.get(pa) + 1);
            } else {
                par.put(pa, 1);
            }
        }
        for (String co : completion) {
            par.put(co, par.get(co) - 1);
        }
        String no = "";
        for (String n : par.keySet()) {
            if (par.get(n) != 0) {
                no = n;
            }
        }
        return no;
    }
}