package com.company.trees;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueJavaImpl {

    public static void main(String[] args){
        //Java APIs for Priority Queue
        PriorityQueue<Integer> pq = new PriorityQueue(5, new PComparator() );
        pq.add(10);
        pq.add(5);
        pq.add(2);
        pq.add(7);
        while(!pq.isEmpty()){
            System.out.print(pq.poll() + " ");
        }
    }

}

class PComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}
