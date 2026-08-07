class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int largest = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i <= n; i++) {
            int current = i == n ? 0 : heights[i];

            while(!stack.isEmpty() && current < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int b = stack.isEmpty() ? i : i - stack.peek() - 1;
                largest = Math.max(largest, b * h);
            }

            stack.push(i);

        }

        return largest;
    }
}
