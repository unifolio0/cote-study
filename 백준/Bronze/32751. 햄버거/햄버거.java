import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); 
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        String S = br.readLine();
        
        boolean isValid = true;
        
        if (S.charAt(0) != 'a' || S.charAt(N - 1) != 'a') {
            isValid = false;
        }
        for (int i = 0; i < N - 1; i++) {
            if (S.charAt(i) == S.charAt(i + 1)) {
                isValid = false;
                break;
            }
        }

        int[] count = new int[4];
        for (int i = 0; i < N; i++) {
            char ch = S.charAt(i);
            if (ch == 'a') count[0]++;
            else if (ch == 'b') count[1]++;
            else if (ch == 'c') count[2]++;
            else if (ch == 'd') count[3]++;
        }

        if (count[0] > A || count[1] > B || count[2] > C || count[3] > D) {
            isValid = false;
        }

        bw.write(isValid ? "Yes\n" : "No\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
