class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int l = 1;
        int r = 1;
        for(int pile : piles) {
            r = Math.max(r, pile);
        }

        while(l <= r) {
            int m = l + (r - l) / 2;
            
            int totalTime = 0;
            for(int pile : piles) {
                double time = (double) pile / m;
                totalTime += Math.ceil(time);
            }

            if(totalTime > h) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }

        }

        return l;
    }
}
