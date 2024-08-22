import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String birth = sc.nextLine();
        int count = sc.nextInt();
        sc.nextLine();
        String[] date = new String[count];
        for (int i = 0; i < count; i++) {
            date[i] = sc.nextLine();
        }

        int i0 = Integer.parseInt(String.valueOf(birth.charAt(0)));
        int i1 = Integer.parseInt(String.valueOf(birth.charAt(1)));
        int i2 = Integer.parseInt(String.valueOf(birth.charAt(2)));
        int i3 = Integer.parseInt(String.valueOf(birth.charAt(3)));
        int i4 = Integer.parseInt(String.valueOf(birth.charAt(4)));
        int i5 = Integer.parseInt(String.valueOf(birth.charAt(5)));
        int i6 = Integer.parseInt(String.valueOf(birth.charAt(6)));
        int i7 = Integer.parseInt(String.valueOf(birth.charAt(7)));

        int max = 0;
        int bio = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            int pow0 = (int) Math.pow(i0 - Integer.parseInt(String.valueOf(date[i].charAt(0))), 2);
            int pow1 = (int) Math.pow(i1 - Integer.parseInt(String.valueOf(date[i].charAt(1))), 2);
            int pow2 = (int) Math.pow(i2 - Integer.parseInt(String.valueOf(date[i].charAt(2))), 2);
            int pow3 = (int) Math.pow(i3 - Integer.parseInt(String.valueOf(date[i].charAt(3))), 2);
            int pow4 = (int) Math.pow(i4 - Integer.parseInt(String.valueOf(date[i].charAt(4))), 2);
            int pow5 = (int) Math.pow(i5 - Integer.parseInt(String.valueOf(date[i].charAt(5))), 2);
            int pow6 = (int) Math.pow(i6 - Integer.parseInt(String.valueOf(date[i].charAt(6))), 2);
            int pow7 = (int) Math.pow(i7 - Integer.parseInt(String.valueOf(date[i].charAt(7))), 2);

            int i8 = pow0 + pow1 + pow2 + pow3;
            int i9 = pow4 + pow5;
            int i10 = pow6 + pow7;
            int i11 = i8 * i9 * i10;
            if (bio < i11) {
                max = Integer.parseInt(date[i]);
                bio = i11;
            } else if (bio == i11) {
                if (max > Integer.parseInt(date[i])) {
                    max= Integer.parseInt(date[i]);
                }
            }
        }
        System.out.println(max);
    }
}
