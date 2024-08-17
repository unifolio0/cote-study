import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] strings = br.readLine().split("");
        List<String> stack = new ArrayList<>();
        int[] muls = new int[31];
        int dep = 0;
        boolean f = true;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("(")) {
                stack.add("(");
                dep++;
            } else if (strings[i].equals("[")) {
                stack.add("[");
                dep++;
            } else if (strings[i].equals(")")) {
                if (stack.isEmpty() || !stack.get(stack.size() - 1).equals("(")) {
                    bw.write("0");
                    f = false;
                    break;
                }
                stack.remove(stack.size() - 1);
                dep--;
                if (muls[dep + 1] != 0) {
                    muls[dep] += muls[dep + 1] * 2;
                    muls[dep + 1] = 0;
                } else {
                    muls[dep] += 2;
                }
            } else if (strings[i].equals("]")) {
                if (stack.isEmpty() || !stack.get(stack.size() - 1).equals("[")) {
                    bw.write("0");
                    f = false;
                    break;
                }
                stack.remove(stack.size() - 1);
                dep--;
                if (muls[dep + 1] != 0) {
                    muls[dep] += muls[dep + 1] * 3;
                    muls[dep + 1] = 0;
                } else {
                    muls[dep] += 3;
                }
            }
        }
        if (f) {
            bw.write(String.valueOf(muls[0]));
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
