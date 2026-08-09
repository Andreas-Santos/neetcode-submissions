class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    
        int left = 1;
        int right = 0;
        for(int pile : piles) {
            right = Math.max(right, pile);
        }

        while(left <= right) {

            int middle = left + (right - left) / 2;
            
            int totalTime = 0;
            for(int pile : piles) {
                double time = (double) pile / middle;
                totalTime += Math.ceil(time);
            }

            if(totalTime > h) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }

        return left;
    }
}
