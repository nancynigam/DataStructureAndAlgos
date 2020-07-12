/**
 * @Date 18/04/2020
 * @author Nancy Nigam
 * Question : Find median of stream of integers
 * Link : https://leetcode.com/problems/find-median-from-data-stream/
 * There are 3 solutions for this question with different complexities.
**/

/**
* Solution1 : Using simple sort
* Complexity : Time : O(nlog(n)), Space : O(n) to hold the incoming streams.
**/
class MedianFinder {
    List<Double> res;
    /** initialize your data structure here. */
    public MedianFinder() {
        res = new ArrayList<>();
    }
    
    public void addNum(int num) {
        res.add(Double.valueOf(num));
    }
    
    public double findMedian() {
        Collections.sort(res);
        int size = res.size();
        if(size%2==0){
            int x=size/2;
            return (res.get(x) + res.get(x-1) )/2;
        }
        else{
            return res.get((size-1)/2);
        }
    }
}

/**
* Solution2 : Using Binary Search
* Complexity : Time : O(log(n)) for Binarysearch + O(n) for Insert ~ O(n), Space : O(n) to hold the incoming streams.
* Since we're having the API to add the element, we can make sure it's always sorted so we can apply binary search. We'll calculate the
* index at which the particular element should be inserted in the array like insertion sort. So searching in sorted array takes O(log(n))
* and inserting elements take O(n) worst case as there might be shifting of elements.
* To know more about Binary search API, look for BinarySearch doc in heaps.
**/

import java.util.*;
class MedianFinder {
    List<Double> res;
    /** initialize your data structure here. */
    public MedianFinder() {
        res = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int index = Collections.binarySearch(res,(double)num);
        /** If key is not present, the it returns "(-(insertion point) - 1)". The insertion point is defined as the point at which the key 
        would be inserted into the list. **/
        if(index<0)
            res.add((-index-1),Double.valueOf(num));
        else
            res.add(index,(double)num);
    }
    
    public double findMedian() {
        int size = res.size();
        if(size%2==0){
            int x=size/2;
            return (res.get(x) + res.get(x-1) )/2;
        }
        else{
            return res.get((size-1)/2);
        }
    }
}

/**
* Solution3 : Using 2 heaps (Min heap + Max heap) 
* Complexity : Time : O(log(n)) for Insert, O(1) for mean, Space : O(n) to hold the incoming streams.
* Concept : we wish to main direct access to median elements at all times so we actually don't need to sort all the elements. If we divide the
* array in 2 equal parts and have max of lower half n min of upper half it's done.. Hence Heap!
* Max heap to store lower elements and min heap to store higher elements and always keep both heaps balanced.
* For 2n elements, Median is (lo.peek()+hi.peek())*/0.5 AND For 2n+1 elements, Median is lo.peek()
**/
    
    class MedianFinder {

    //max-heap
    PriorityQueue<Integer> lo;
    //min-heap
    PriorityQueue<Integer> hi;
    /** initialize your data structure here. */
    public MedianFinder() {
        lo = new PriorityQueue<>();
        hi = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        lo.offer(num);
        hi.offer(lo.poll());
        if(lo.size()<hi.size()){
            lo.offer(hi.poll());
        }
    }
    
    public double findMedian() {
        if(lo.size() == hi.size())
            return (lo.peek()+hi.peek())*0.5;
        else
            return lo.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
