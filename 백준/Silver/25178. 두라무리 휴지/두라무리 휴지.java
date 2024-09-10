import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String A = br.readLine();
        String B = br.readLine();
        int[] al = new int[26];
        int[] bl = new int[26];
        List<Character> ch = List.of('a', 'i', 'o', 'u', 'e');
        List<Character> An = new ArrayList<>();
        List<Character> Bn = new ArrayList<>();
        if (A.charAt(0) == B.charAt(0) && A.charAt(N - 1) == B.charAt(N - 1)) {
            for (int i = 0; i < N; i++) {
                al[A.charAt(i) - 'a']++;
                bl[B.charAt(i) - 'a']++;
                if (!ch.contains(A.charAt(i))) {
                    An.add(A.charAt(i));
                }
                if (!ch.contains(B.charAt(i))) {
                    Bn.add(B.charAt(i));
                }
            }
            if (An.equals(Bn)) {
                if (Arrays.equals(al, bl)) {
                    bw.write("YES");
                } else {
                    bw.write("NO");
                }
            } else {
                bw.write("NO");
            }
        } else {
            bw.write("NO");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
