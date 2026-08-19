class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> days = new Stack<>();
        for(int i = 0; i < n; i++) {

            while(!days.isEmpty() && temperatures[i] > temperatures[days.peek()]) {
                int index = days.pop();
                result[index] = i - index;
            }

            days.push(i);
        }

        return result;
    }
}
