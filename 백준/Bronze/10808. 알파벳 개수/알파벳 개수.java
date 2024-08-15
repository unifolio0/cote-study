import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] alphabet = new int[26];
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a'] += 1;
        }

        for (int a : alphabet) {
            System.out.print(a + " ");
        }
    }
}