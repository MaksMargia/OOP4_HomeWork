package GbCollections.Lists.Utils;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
    private E[] array;
    private int index;

    public ArrayIterator(E[] array) {
        this.array = array;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public E next() {
        return array[index++];
    }
}