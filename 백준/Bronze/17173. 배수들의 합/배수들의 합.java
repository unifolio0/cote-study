import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = sc.nextLine();

        int M = Integer.parseInt(s.split(" ")[1]);
        int[] num = new int[M];
        for (int i = 0; i < M; i++) {
            num[i] = Integer.parseInt(s1.split(" ")[i]);
        }

        Set<Integer> mul = new HashSet<>();
        int N = Integer.parseInt(s.split(" ")[0]);

        for (int n : num) {
            for (int i = 1; i < N + 1; i++) {
                if (i % n == 0) {
                    mul.add(i);
                }
            }
        }

        System.out.println(mul.stream().mapToInt(i -> i).sum());
    }
}