import java.util.*;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        boolean[] vA = new boolean[A.length + 1];
        boolean[] vB = new boolean[B.length + 1];
        int[] C = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            vA[A[i]] = true;
            vB[B[i]] = true;
            int count = 0;
            for (int j = 0; j <= A.length; j++) {
                if (vA[j] && vB[j]) {
                    count++;
                }
                C[i] = count;
            }
        }
        return C;
    }
}
