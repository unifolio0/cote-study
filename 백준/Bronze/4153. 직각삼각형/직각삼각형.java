import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        while (true) {
            nums.add(scan.nextInt());
            nums.add(scan.nextInt());
            nums.add(scan.nextInt());
            if (nums.get(0) == 0 && nums.get(1) == 0 && nums.get(2) == 0) {
                scan.close();
                break;
            }
            nums.sort(null);
            if ((nums.get(0)*nums.get(0)) + (nums.get(1) * nums.get(1)) == (nums.get(2) * nums.get(2))) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
            nums.clear();
        }
    }
}