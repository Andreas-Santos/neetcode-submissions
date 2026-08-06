class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        // calculate the time to each car reach the target

        int n = position.length;
        double[][] cars = new double[n][2];
        for(int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (target - cars[i][0]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        double prevTime = 0;
        int fleets = 0;
        for(double[] car : cars) {
            if(car[1] > prevTime) {
                fleets++;
                prevTime = car[1];
            }
        }

        return fleets;
    }
}
