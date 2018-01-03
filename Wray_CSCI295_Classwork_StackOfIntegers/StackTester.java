public class StackTester {
    public static void main(String[] args) {
        MyStackOfIntegers stack = new StackOfIntegers();
        System.out.println(stack);
        
        stack.push(2);
        System.out.println(stack);
        
        stack.push(3);
        System.out.println(stack);
        
        stack.push(5);
        System.out.println(stack);
        
        int x = stack.pop();
        System.out.println("s = " + x);
        System.out.println(stack);

        x = stack.pop();
        System.out.println("s = " + x);
        System.out.println(stack);
        
        for(int i = 10; i < 40; i += 2){
            stack.push(i);
        }
        
        System.out.println(stack);
        
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    
    }
}