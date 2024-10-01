import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        // 말뚝 위치 입력받기
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // 깃대 높이 입력받기
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        // 이분탐색을 위해 깃대 정렬
        Arrays.sort(B);
        
        double f = -1;
        
        // 2개의 말뚝을 정하기 위한 2중 for문 O(N^2)
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int start = 0;
                int end = M - 1;
                // 넓이가 R을 넘지않는 깃대 이분탐색으로 찾기 O(logN)
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (Math.abs(A[i] - A[j]) * B[mid] <= R * 2) {
                        start = mid + 1;
                        f = Math.max(f, Math.abs(A[i] - A[j]) * B[mid] / 2.0);
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }
        if (f == -1) {
            bw.write("-1");
        } else {
            bw.write(String.format("%.1f", f));
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
