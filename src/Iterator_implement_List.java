import java.util.*;

/**
 * Use List to implement the Iterator
 */
public class Iterator_implement_List implements Iterator<Vector>{
    private List<Vector> list;
    private int index;
    @Override
    public boolean hasNext() {
        return !(list.size()==index);
    }

    @Override
    public Vector next() {
        if(hasNext()){
            return list.get(index++);
        }else {
            throw new NoSuchElementException("There are no elements");
        }
    }

    @Override
    public void remove() {
        if(index<=0){
            throw new IllegalStateException("You can't delete element before first next() method call");
        }
        list.remove(--index);
    }
}
