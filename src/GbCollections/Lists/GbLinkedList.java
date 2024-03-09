package GbCollections.Lists;

import GbCollections.GbList;
import GbCollections.Lists.Utils.GbLinckedListItegator;
import GbCollections.Lists.Utils.Node;
import java.util.Iterator;

public class GbLinkedList<E> implements GbList<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private Node<E> currentNode;
    private Node<E> prevNode;
    private int size;
    public GbLinkedList() {
        this.size = 0;
    }



    private Node<E> addNode(Node<E> prev, E value, Node<E> next){
        this.size++;
        return new Node<>(prev, value, next);
    }

    private Node<E> findNodeByIndex(int index){
        Node<E> currentNode = firstNode;
        int i = 0;
        while (i < index) {
            currentNode = currentNode.next;
            i++;
        }
        return currentNode;
    }
    @Override
    public void add(E value) {
        if (size == 0) {
            firstNode = addNode(null, value, null);
            lastNode = firstNode;
        } else {
            currentNode = lastNode;
            lastNode = addNode(currentNode, value, null);
            currentNode.next = lastNode;
        }
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            if (firstNode != null) {
                prevNode = firstNode;
                firstNode = addNode(null, value, prevNode);
                prevNode.prev = firstNode;
            } else {
               add(value);
            }
        } else if (index == size) {
            lastNode = addNode(lastNode, value, null);
        } else {
            currentNode = findNodeByIndex(index);
            currentNode.prev.next = addNode(currentNode.prev, value, currentNode);

        }
    }

    @Override
    public E get(int index) {
        return findNodeByIndex(index).value;
    }

    @Override
    public void remove(E value) {
        Iterator<E> iterator = iterator();
        int currentIndex = 0;
        while (iterator.hasNext()){
            if (value.equals(iterator.next())) {
                removeByIndex(currentIndex+1);
                return;
            }
            currentIndex++;
        }
    }

    @Override
    public void removeByIndex(int index) {
        Node<E> currentNode = findNodeByIndex(index);
        if (index == 0){
            firstNode = currentNode.next;
        } else if (index == (size - 1)){
            lastNode = currentNode.prev;
            lastNode.next = null;
        } else {
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        this.currentNode = this.firstNode;
        StringBuilder builder = new StringBuilder("[");
        while (this.currentNode.next != null) {
            builder.append(this.currentNode.value).append(", ");
            this.currentNode = this.currentNode.next;
        }
        builder.append(this.currentNode.value).append("]");
        if (builder.length() == 1)
            return "[]";
        return builder.toString();
        }

    @Override
    public Iterator<E> iterator() {
        return new GbLinckedListItegator<>(firstNode);
    }
}