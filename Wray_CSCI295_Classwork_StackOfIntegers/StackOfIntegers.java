
import java.util.ArrayList;

public class StackOfIntegers implements MyStackOfIntegers {
    ArrayList<Integer> list;
    
    public StackOfIntegers(){
        list = new ArrayList<>();
    }
    
    @Override
    public void push(int item){
        list.add(item);
    }
    
    @Override
    public int pop(){
        int size = list.size();
        int tos = list.remove(size - 1);
        return tos;
    }

    @Override
    public int top(){
        int size = list.size();
        int tos = list.get(size - 1);
        return tos;
    }
    
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public int size(){
        return list.size();
    }
    
    @Override
    public String toString(){
        String s = "";
        s = s + list.toString();
        s = s + " TOS";
        
        return s;
    }
    
}