import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            a.add(sc.nextInt());
        }

        for (int i = 0; i < M; i++) {
            b.add(sc.nextInt());
        }

        int minA = Integer.MAX_VALUE;
        int minA2 = Integer.MAX_VALUE;
        int positionA = 0;
        for (int aa : a) {
            if (minA > aa) {
                minA = aa;
                minA2 = aa;
                positionA = a.indexOf(aa) + 1;
            }
        }
        if (minA > b.get(0)) {
            positionA = N;
        }

        int minB = Integer.MAX_VALUE;
        int positionB = 0;
        for (int bb : b) {
            if (minB > bb) {
                minB = bb;
                positionB = b.indexOf(bb) + 1;
            }
        }
        System.out.println(positionA + " " + positionB);
    }
}