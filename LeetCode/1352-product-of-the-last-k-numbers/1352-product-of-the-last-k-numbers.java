import java.util.*;

class ProductOfNumbers {

    private List<Integer> nums;

    public ProductOfNumbers() {
        nums = new ArrayList<>();
        nums.add(1);
    }

    public void add(int num) {
        if (num != 0) {
            nums.add(nums.get(nums.size() - 1) * num);
            return;
        }
        nums = new ArrayList<>();
        nums.add(1);
    }

    public int getProduct(int k) {
        if (nums.size() <= k) {
            return 0;
        }
        return nums.get(nums.size() - 1) / nums.get(nums.size() - k - 1);
    }
}
