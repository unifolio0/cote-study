import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int B = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < R; j++) {
                if ((i * 2) + (j - 2) * 2 == R && (i - 2) * (j - 2) == B) {
                    System.out.println(j + " " + i);
                    System.exit(0);
                }
            }
        }

//        int extent = R + B;
//        int sqrt = (int) Math.sqrt(extent);
//
//        int i = extent / sqrt;
//        System.out.println(i + " " + sqrt);
    }
}
