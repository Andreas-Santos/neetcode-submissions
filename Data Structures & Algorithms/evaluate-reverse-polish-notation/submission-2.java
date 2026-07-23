class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>(Set.of("+", "-", "*", "/"));

        for(String token : tokens) {

            if(!set.contains(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }

            int b = stack.pop();
            int a = stack.pop();
            
            int result;
            switch(token) {
                case "+":
                    result = a + b;
                    stack.push(result);
                    break;
                case "-":
                    result = a - b;
                    stack.push(result);
                    break;
                case "*":
                    result = a * b;
                    stack.push(result);
                    break;
                case "/":
                    result = a / b;
                    stack.push(result);
                    break;
            }
        }

        return stack.pop();
    }
}
