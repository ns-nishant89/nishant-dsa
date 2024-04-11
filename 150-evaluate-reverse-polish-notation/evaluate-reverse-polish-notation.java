class Solution {
    private static final Set<String>operations = new HashSet<>(Set.of("+","-","*","/"));
    
    public int evalRPN(String[] tokens) {
        Stack<Integer>stack = new Stack<>();
        for(String t:tokens){
            if(!operations.contains(t)){
                stack.push(Integer.parseInt(t));
            }else{
                int b = stack.pop();
                int a = stack.pop();
            
            switch(t){
                case "+":
                stack.push(a+b);
                break;

                case "-":
            stack.push(a-b);
                break;

                 case "*":
                stack.push(a*b);
                break;

                 case "/":
                stack.push(a/b);
                break;
            }
          }
        }
        return stack.pop();
    }
}