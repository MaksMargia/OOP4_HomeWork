package GbCollections.Lists.Utils;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class GbLinckedListItegator<E> implements Iterator<E> {
    private Node<E> currentNode;

    public GbLinckedListItegator (Node<E> node){
        this.currentNode = node;
    }

    @Override
    public boolean hasNext() {
        return this.currentNode != null;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.currentNode = this.currentNode.next;
        return this.currentNode.value;
    }
}

