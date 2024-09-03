import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder(sc.nextLine());

        int j = 0;
        if (s.length() % 3 != 0) {
            j = 3 - (s.length() % 3);
        }

        for (int i = 0; i < j; i++) {
            s.insert(0, "0");
        }

        StringBuilder sum = new StringBuilder();
        for (int i = 0; i < s.length(); i+=3) {
            sum.append((Character.getNumericValue(s.charAt(i)) * 4) + (Character.getNumericValue(s.charAt(i + 1)) * 2)
                    + Character.getNumericValue(s.charAt(i + 2)));
        }
        System.out.println(sum);
    }

}
