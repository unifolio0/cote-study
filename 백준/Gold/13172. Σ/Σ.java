import java.util.Scanner;

public class Main {
    // Define the large prime MOD
    static final int MOD = 1_000_000_007;

    // Function to compute modular inverse using Fermat's Little Theorem
    static long modInverse(long b, int mod) {
        return modPow(b, mod - 2, mod);
    }

    // Function to compute (base^exp) % mod using iterative squaring
    static long modPow(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) { // If exp is odd, multiply the base with result
                result = (result * base) % mod;
            }
            base = (base * base) % mod; // Square the base
            exp >>= 1; // Divide exp by 2
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of dice
        int M = scanner.nextInt();
        long result = 0;

        // Iterate through each die
        for (int i = 0; i < M; i++) {
            long N = scanner.nextLong(); // Number of faces
            long S = scanner.nextLong(); // Sum of the numbers on the faces

            // Calculate expectation Si/Ni = S * (N^-1) % MOD
            long inverseN = modInverse(N, MOD);
            long expectation = (S * inverseN) % MOD;

            // Add the expectation of this die to the total result
            result = (result + expectation) % MOD;
        }

        // Output the final result
        System.out.println(result);

        scanner.close();
    }
}
