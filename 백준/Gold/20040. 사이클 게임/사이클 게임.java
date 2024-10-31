import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int answer = 0;
        boolean noCycle = true;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = find(parent, a);
            int l = find(parent, b);
            if (noCycle && k == l) {
                answer = i + 1;
                noCycle = false;
            } else {
                if (k > l) {
                    parent[k] = l;
                } else {
                    parent[l] = k;
                }
            }
        }
        bw.write(String.valueOf(answer));
        
        bw.flush();
        
        bw.close();
        br.close();
    }
    
    static int find(int[] parent, int c) {
        if (parent[c] == c) {
            return c;
        }
        return find(parent, parent[c]);
    }
}