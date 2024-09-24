import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] dominos = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                dominos[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        String[][] dominoStatus = new String[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dominoStatus[i][j] = "S";
            }
        }
        int score = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            String D = st.nextToken();
            if (D.equals("E")) {
                int s = dominoStatus[X][Y].equals("S") ? dominos[X][Y] - 1 : 0;
                for (int j = Y; j <= M; j++) {
                    if (s < 0) {
                        break;
                    }
                    if (dominoStatus[X][j].equals("S")) {
                        s = Math.max(s, dominos[X][j] - 1);
                        dominoStatus[X][j] = "F";
                        score++;
                    }
                    s--;
                }
            } else if (D.equals("W")) {
                int s = dominoStatus[X][Y].equals("S") ? dominos[X][Y] - 1 : 0;
                for (int j = Y; j > 0; j--) {
                    if (s < 0) {
                        break;
                    }
                    if (dominoStatus[X][j].equals("S")) {
                        s = Math.max(s, dominos[X][j] - 1);
                        dominoStatus[X][j] = "F";
                        score++;
                    }
                    s--;
                }
            } else if (D.equals("S")) {
                int s = dominoStatus[X][Y].equals("S") ? dominos[X][Y] - 1 : 0;
                for (int j = X; j <= N; j++) {
                    if (s < 0) {
                        break;
                    }
                    if (dominoStatus[j][Y].equals("S")) {
                        s = Math.max(s, dominos[j][Y] - 1);
                        dominoStatus[j][Y] = "F";
                        score++;
                    }
                    s--;
                }
            } else if (D.equals("N")) {
                int s = dominoStatus[X][Y].equals("S") ? dominos[X][Y] - 1 : 0;
                for (int j = X; j > 0; j--) {
                    if (s < 0) {
                        break;
                    }
                    if (dominoStatus[j][Y].equals("S")) {
                        s = Math.max(s, dominos[j][Y] - 1);
                        dominoStatus[j][Y] = "F";
                        score++;
                    }
                    s--;
                }
            }

            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            dominoStatus[X][Y] = "S";
        }

        bw.write(score + "\n");
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                bw.write(dominoStatus[i][j] + " ");
            }
            bw.write("\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
