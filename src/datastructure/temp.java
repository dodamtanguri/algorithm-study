package datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class temp {


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.offer(2);
        queue.remove(1);
        System.out.println(queue);
    }

}
