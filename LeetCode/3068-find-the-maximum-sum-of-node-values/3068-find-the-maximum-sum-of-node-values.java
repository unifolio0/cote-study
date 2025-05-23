class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long res = 0;
        long count = 0;
        int sub = Integer.MAX_VALUE;
        for (int num : nums) {
            System.out.println(num + " " + (num ^ k));
            res += Math.max(num, num ^ k);
            count += num > (num ^ k) ? 0 : 1;
            sub = Math.min(sub, Math.abs(num - (num ^ k)));
        }
        System.out.println(count + " " + sub + " " + res);
        if (count % 2 == 0) {
            return res;
        }
        return res - sub;
    }
}
