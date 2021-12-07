package datastructure;

import java.util.ArrayList;

/*
Java ArrayList 를 활용해 enqueue,dequeue 기능 구현하기
 */
public class Queue<T> {
    private ArrayList<T> queue = new ArrayList<T>();

    public void enqueue(T n) {
        queue.add(n);
    }

    public T dequeue() {
        if (queue.isEmpty()) {
            //큐에 데이터가 없을 경우 return null;
            return null;
        }
        //가장 앞에 있는 데이터를 삭제
        return queue.remove(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Queue<Integer> queue1 = new Queue<Integer>();
        queue1.enqueue(1);
        queue1.enqueue(135);
        System.out.println(queue1.dequeue());
    }
}