import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String ppap = br.readLine().replace("\n", "");
        String[] split = ppap.split("");
        List<String> stack = new ArrayList<>();

        boolean pp = true;
        for (int i = 0; i < split.length; i++) {
            stack.add(split[i]);
            if (split[i].equals("A")) {
                if (i == split.length - 1) {
                    pp = false;
                    break;
                }
                stack.add(split[++i]);
                if (stack.size() < 4) {
                    pp = false;
                    break;
                }
                List<String> tmp = new ArrayList<>();
                for (int j = 0; j < 4; j++) {
                    tmp.add(stack.get(stack.size() - 1 - j));
                }
                if (String.join( "", tmp).equals("PAPP")) {
                    for (int j = 0; j < 4; j++) {
                        stack.remove(stack.size() - 1);
                    }
                    stack.add("P");
                } else {
                    pp = false;
                    break;
                }
            }
        }
        if (pp && String.join( "", stack).equals("P")) {
            bw.write("PPAP");
        } else {
            bw.write("NP");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
