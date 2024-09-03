import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        BigInteger b2 = new BigInteger(s, 2);
        String sum = b2.toString(8);

        System.out.println(sum);
    }

}
