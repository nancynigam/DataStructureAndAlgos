The offer(E e) method of Queue Interface inserts the specified element into this queue if it is possible to do so immediately 
without violating capacity restrictions. 
This method is preferable to add() method since this method does not throws an exception when the capacity of the container is 
full since it returns false.

It however throws following exceptions :
ClassCastException -> Since it has generics, if you add something other than that it throws this exception. 
IllegalArgumentException -> Thrown to show the method has been passed an illegal argument i.e. argument might be out of range or
of invalid format etc.
NullPointerException -> When try to add null value to the queue


 Queue<Integer> Q = new LinkedBlockingQueue<Integer>(3); 
        if (Q.offer(10)) 
            System.out.println("The Queue is not full" + " and 10 is inserted"); 
        else
            System.out.println("The Queue is full"); 
          
That said, whether you use add or offer, it'll let you add elements indefinitely, the benefit with offer is you can check using
Q.offer if it's full or not.

How to resize a priority Queue :
You do not need to provide a size parameter, the default constructor will return one with a default initial capacity of 11. 
This capacity will be incremented by 2 x whenever it is needed, so you don't really need to worry about that.
            
 Priority Queue by default is a min Heap implementation. i.e. elements will be arranged in an increasing order with basic constructors.

following are the Complexities of the operations which are same for both priorityqueue and heap :
1. Find max/min element : O(1)
2. queue / dequeue element : O(logn)
 
when we use comparator in priority queue it results in O(logn) operations as opposed to collection.sort where it uses merge sort bcz
PriorityQueue is based on Heap which are partially ordered n not completely ordered. It's main aim is just to get the min/max element.Rest
elements are not sorted.

https://stackoverflow.com/questions/25569625/sorting-priority-queue-in-java
A PriorityQueue is what is called a binary heap. It is only ordered/sorted in the sense that the first element is the least. In other word, it only cares about what is in the front of the queue, the rest are "ordered" when needed.
The elements are only ordered as they are dequeued, i.e. removed from the queue using poll(). 
This is the reason why a PriorityQueue manages to have such good performance, as it is not doing any more sorting than it needs at any time.
If you want to know how heaps work in detail I recommend this MIT lecture on heaps.
 
Details about Java Priority Queue API :
https://www.journaldev.com/1642/java-priority-queue-priorityqueue-example
https://howtodoinjava.com/java/collections/java-priorityqueue/

1. PriorityQueue is an unbounded queue based on a priority heap and the elements of the priority queue are ordered by default in natural order(Increasing order).
2. We can provide a Comparator for ordering at the time of instantiation of priority queue.
3. Java Priority Queue doesn’t allow null values and we can’t create PriorityQueue of Objects that are non-comparable.
4. The head of the priority queue is the least element based on the natural ordering or comparator based ordering, 
   if there are multiple objects with same ordering, then it can poll any one of them randomly. When we poll the queue, it returns the head object from the queue.
5. Java Priority Queue size is unbounded but we can specify the initial capacity at the time of it’s creation.
   When we add elements to the priority queue, it’s capacity grows automatically.
6. PriorityQueue is not thread safe, so java provides PriorityBlockingQueue class that implements the BlockingQueue interface to use in java multithreading environment.
7. Java Priority Queue implementation provides O(log(n)) time for enqueing and dequeing method.
