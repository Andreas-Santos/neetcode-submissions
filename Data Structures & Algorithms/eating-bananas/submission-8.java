class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int maxPile = 0;
        for(int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int left = 0;
        int right = maxPile;
        while(left <= right) {
            int mid = left + (right - left) / 2;

            int totalTime = 0;
            for(int pile : piles) {
                double time = (double) pile / mid;
                totalTime += Math.ceil(time);
            }

            if(totalTime > h) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return left;
    }
}
