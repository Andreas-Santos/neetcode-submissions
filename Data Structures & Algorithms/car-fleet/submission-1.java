class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        /*
            A fleet is considered a group that reach the end (target) together

            The idea here is to have a HashMap of the positions and the time to
            reach the end for each car (the time can be calculated as the equation
            (target - position) / speed).
            This can be stored in a hashmap or in a matrix[n][2] where the n is
            the size of the position or speed array (quantity of cars).
            This matrix needs to be a double data type matrix to not make a ceil
            round of the division, since we needs to get the exactly time for this calculate.

            After it it's need to sort the matrix by the position of the cars in descending
            order, so we are going to have a matrix sorted by the position of each car.

            Now to calculate the quantity of fleets we just need to think that:
                - A car that haves a better position just will join with another one
                    to create a fleet if the car that comes next have a better time to reach
                    the end than it.
                
            By that we know that everytime a car has a worst time than previous we are going
            to create a new Fleet.
        */

        int n = position.length;

        double[][] cars = new double[n][2];
        for(int i = 0; i < n; i++) {

            cars[i][0] = position[i];
            cars[i][1] = (target - cars[i][0]) / speed[i]; // is going to store

        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double prevTime = 0;
        for(double[] car : cars) {
            if(car[1] > prevTime) {
                fleets++;
                prevTime = car[1];
            }
        } 

        return fleets;
    }
}
