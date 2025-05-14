import java.util.*;

class Solution {
    int mod = 1000000007;
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        int[][] matrix = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                matrix[i][(i + j) % 26] = 1;
            }
        }

        int[][] matrix2 = f1(matrix, t);
        for (int[] row : matrix2) {
            System.out.println(Arrays.toString(row));
        }
        int[] result = f2(counts, matrix2);
        int ret = 0;
        for (int r : result) {
            ret = (ret + r) % mod;
        }
        return ret;
    }

    private int[][] f1(int[][] matrix, int t) {
        int[][] res = new int[26][26];
        for (int i = 0; i < 26; i++) {
            res[i][i] = 1;
        }
        while (t > 0) {
            if (t % 2 == 1) {
                res = multiply(res, matrix);
            }
            matrix = multiply(matrix, matrix);
            t /= 2;
        }
        return res;
    }

    private int[][] multiply(int[][] matrix, int[][] matrix1) {
        int[][] res = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    res[i][j] = (int) ((res[i][j] + (1L * matrix[i][k] * matrix1[k][j]) % mod) % mod);
                }
            }
        }
        return res;
    }

    private int[] f2(int[] counts, int[][] matrix) {
        int[] res = new int[26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                res[i] = (int) ((res[i] + (1L * counts[j] * matrix[j][i]) % mod) % mod);
            }
        }
        return res;
    }
}
