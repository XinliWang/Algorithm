import java.util.Iterator;

/**
 * Given an Iterator class interface with methods: next() and hasNext(),
 * design and implement a PeekingIterator that support the peek() operation --
 * it essentially peek() at the element that will be returned by the next call to next().

 Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

 Call next() gets you 1, the first element in the list.

 Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

 You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class Peeking_Iterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer cache;
    public Peeking_Iterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        cache = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        //if cache!=null,it means we have execute this function,but the index doesn't change
        if(cache!=null){
            cache = iterator.next();
        }
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer value;
        if(cache!=null){
           value = cache;
        }else{
           value = iterator.next();
        }
        //change index, initialize cache
        cache = null;
        return value ;
    }

    @Override
    public boolean hasNext() {
        //cache!=null means we have executed the next() operation
       if(cache!=null || iterator.hasNext()){
           return true;
       }else{
           return false;
       }
    }
}
