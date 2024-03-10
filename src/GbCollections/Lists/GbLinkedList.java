package GbCollections.Lists;

import GbCollections.GbList;
import GbCollections.Lists.Utils.GbLinckedListItegator;
import GbCollections.Lists.Utils.Node;
import java.util.Iterator;

public class GbLinkedList<E> implements GbList<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
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
            Node<E> currentNode = lastNode;
            lastNode = addNode(lastNode, value, null);
            currentNode.next = lastNode;
        }
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
        Node<E> currentNode;
        if (index == 0) {
            if (firstNode != null) {
                currentNode = firstNode;
                firstNode = addNode(null, value, currentNode);
                currentNode.prev = firstNode;
            } else {
               add(value);
            }
        } else if (index == size) {
             add(value);
             //lastNode = addNode(lastNode, value, null);
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
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
        Node<E> currentNode = this.firstNode;
        StringBuilder builder = new StringBuilder("[");
        while (currentNode.next != null) {
            builder.append(currentNode.value).append(", ");
            currentNode = currentNode.next;
        }
        builder.append(currentNode.value).append("]");
        if (builder.length() == 1)
            return "[]";
        return builder.toString();
        }

    @Override
    public Iterator<E> iterator() {
        return new GbLinckedListItegator<>(firstNode);
    }
}