import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<String> collect = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());
        int[] cc = new int[Integer.parseInt(s.split(" ")[1])];
        int max = 0;
        for (int i = 0; i < collect.size(); i++) {
            cc[Integer.parseInt(collect.get(i)) - 1]++;
            if (cc[max] < cc[Integer.parseInt(collect.get(i)) - 1]) {
                max = Integer.parseInt(collect.get(i)) - 1;
            }
        }
        System.out.println(cc[max]);
    }
}
