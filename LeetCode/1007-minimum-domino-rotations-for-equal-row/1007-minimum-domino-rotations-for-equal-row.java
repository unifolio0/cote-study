class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int min = 20001;
        for (int i = 1; i <= 6; i++) {
            int topc = 0;
            int bottomc = 0;
            boolean end = true;
            for (int j = 0; j < tops.length; j++) {
                if (tops[j] == i && bottoms[j] == i) {
                    continue;
                }
                if (tops[j] == i) {
                    bottomc++;
                } else if (bottoms[j] == i) {
                    topc++;
                } else {
                    end = false;
                    break;
                }
            }
            if (end) {
                min = Math.min(topc, Math.min(bottomc, min));
            }
        }
        return min == 20001 ? -1 : min;
    }
}
