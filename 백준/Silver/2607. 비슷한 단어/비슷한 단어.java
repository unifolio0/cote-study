import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] alp = new int[26];
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        String word = words[0];
        for (int i = 0; i < word.length(); i++) {
            alp[word.charAt(i) - 'A']++;
        }
        int res = 0;
        for (int i = 1; i < N; i++) {
            int[] copy = alp.clone();
            int c = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (copy[words[i].charAt(j) - 'A'] > 0) {
                    copy[words[i].charAt(j) - 'A']--;
                    c++;
                }
            }
            if (word.length() == words[i].length() && Math.abs(c - word.length()) <= 1) {
                res++;
            } else if (word.length() + 1 == words[i].length() && c == word.length()) {
                res++;
            } else if (word.length() - 1 == words[i].length() && c - word.length() == -1) {
                res++;
            }
        }
        bw.write(String.valueOf(res));

        bw.flush();

        bw.close();
        br.close();
    }
}
