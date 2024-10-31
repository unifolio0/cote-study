import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] sudoku = new int[9][9];
    static int[][] solved = new int[9][9];
    
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(row[j]);
                solved[i][j] = sudoku[i][j];
            }
        }
        solve(0, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(String.valueOf(solved[i][j]));
            }
            bw.write("\n");
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
    
    public static boolean solve(int x, int y) {
        if (x == 9) return true;
        int nextx = x + ((y + 1) / 9);
        int nexty = (y + 1) % 9;
        if (sudoku[x][y] != 0) {
            solved[x][y] = sudoku[x][y];
            return solve(nextx, nexty);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (rowOk(x, y, i) && colOk(x, y, i) && squareOk(x, y, i)) {
                    solved[x][y] = i;
                    boolean ok = solve(nextx, nexty);
                    if (ok) {
                        return true;
                    }
                }
                solved[x][y] = 0;
            }
        }
        return false;
    }
    
    public static boolean rowOk(int x, int y, int k) {
        for (int i = 0; i < 9; i++) {
            if (solved[x][i] == k) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean colOk(int x, int y, int k) {
        for (int i = 0; i < 9; i++) {
            if (solved[i][y] == k) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean squareOk(int x, int y, int k) {
        for (int i = (x / 3) * 3; i < ((x / 3) * 3) + 3; i++) {
            for (int j = (y / 3) * 3; j < ((y / 3) * 3) + 3; j++) {
                if (solved[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }
}