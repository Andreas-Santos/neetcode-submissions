class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int l = 1;
        int r = 0;
        for(int pile : piles) {
            r = Math.max(r, pile);
        }

        int result = 0;
        while(l <= r) {

            int mid = l + (r - l) / 2;

            long totalTime = 0;
            for(int pile : piles) {
                totalTime += Math.ceil((double) pile / mid);
            }

            if(totalTime > h) {
                l = mid + 1;
            }
            else {
                result = mid;
                r = mid - 1;
            }
        }  

        return result;
    }
}
