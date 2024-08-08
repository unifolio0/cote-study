import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] strings = br.readLine().split("");
        String[] bomb = br.readLine().split("");
        List<String> stack = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            stack.add(strings[i]);
            if (stack.size() < bomb.length) {
                continue;
            }
            boolean pop = true;
            for (int j = 0; j < bomb.length; j++) {
                if (!stack.get(stack.size() - (bomb.length - j)).equals(bomb[j])) {
                    pop = false;
                    break;
                }
            }
            if (pop) {
                for (int j = 0; j < bomb.length; j++) {
                    stack.remove(stack.size() - 1);
                }
            }
        }
        if (stack.isEmpty()) {
            bw.write("FRULA");
        } else {
            bw.write(String.join("", stack));
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
