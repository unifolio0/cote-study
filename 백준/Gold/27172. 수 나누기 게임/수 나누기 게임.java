import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        boolean[] exist = new boolean[1000001];
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            exist[k] = true;
            a[i] = k;
            max = Math.max(max, k);
        }
        int[] score = new int[1000001];
        for (int i = 0; i < N; i++) {
            int tar = a[i];
            int temp = 0;
            for (int j = tar * 2; j <= max; j+=tar) {
                if (exist[j]) {
                    score[tar]++;
                    score[j]--;
                }
            }
        }
        
        for (int t : a) {
            bw.write(score[t] + " ");
        }
        
        bw.flush();

        bw.close();
        br.close();
    }
}