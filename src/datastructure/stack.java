package datastructure;

import java.util.ArrayList;

public class stack<T> {
    private ArrayList<T> myStack = new ArrayList<T>();

    public void push(T n) {
        myStack.add(n);
    }
    public T pop() {
        if(myStack.isEmpty()){
            return null;
        }
        return myStack.remove(myStack.size()-1);
    }
    public boolean isEmpty() {
        return myStack.isEmpty();
    }

    public static void main(String[] args) {
        stack<Integer> ms = new stack<>();
        ms.push(1);
        ms.push(2);
        System.out.println(ms.pop());
        ms.push(3);
        System.out.println(ms.pop());
        System.out.println(ms.pop());
    }
}
