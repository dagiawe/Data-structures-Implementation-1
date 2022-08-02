package Implementation;

import java.util.Arrays;

public class AbebeLinkedList<E> implements AbebeList<E> {

    private Node<E> head, tail;
    private int size = 0;

    public AbebeLinkedList() {
    }

    // Create a list from an array of objects
    public AbebeLinkedList(E[] objects) {
        this.addAll(Arrays.asList(objects));
    }

    // Return the head element in the list
    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    // Return the last element in the list
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    // Add an element to the beginning of the list
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size
        if (tail == null) // The new node is the only node in list
            tail = head;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node for e
        if (tail == null) {
            head = tail = newNode; // The only node in list
        } else {
            tail.next = newNode; // Link the new node with the last node
            tail = newNode; // tail now points to the last node
        }
        size++; // Increase size
    }

    @Override
    public void add(int index, E e) {
        if (index == 0) addFirst(e);
        else if (index >= size) addLast(e);
        else {
            Node<E> current = head;
            for (int i = 1; i < index; i++)
                current = current.next;
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }

    public E removeFirst() {
        if (size == 0) return null;
        else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) tail = null;
            return temp.element;
        }
    }

    public E removeLast() {
        if (size == 0 || size == 1) {
            return removeFirst();
        } else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            E temp = tail.element;
            tail = current;
            tail.next = null;
            size--;
            return temp;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) return null; // Out of range
        else if (index == 0) return removeFirst(); // Remove first
        else if (index == size - 1) return removeLast(); // Remove last
        else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", ");
            } else {
                result.append("]");
            }
        }
        return result.toString();
    }

    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    public boolean contains(Object e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0)
            return null;
        Node<E> Current = null;
        if (head != null) {
            Current = head.next;
            for (int i = 0; i < index - 1; i++) {
                if (Current.next == null)
                    return null;
                Current = Current.next;
            }
            return Current.element;
        }
        return Current.element;
    }

    @Override
    public int indexOf(Object e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e))
                return i;
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        int index = -1;
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e))
                index = i;
            current = current.next;
        }
        return index;
    }

    @Override
    public E set(int index, E e) {
        E elementToReturn = null;
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                elementToReturn = current.element;
                current.element = e;
                return elementToReturn;
            }
            current = current.next;
        }
        return elementToReturn;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator
            implements java.util.Iterator<E> {
        private Node<E> current = head;
        private Node<E> pre1 = null;
        private Node<E> pre2 = null;
        boolean removeCall = false;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.element;
            pre2 = pre1;
            pre1 = current;
            current = current.next;
            removeCall = false;
            return e;
        }

        @Override
        public void remove() {
            if (pre1 == null || removeCall) {
                throw new IllegalStateException();
            }
            if (pre2 == null) {
                head = current;
            } else {
                current = pre1.next;
            }
            size--;
            removeCall = true;
        }
    }

    public void OutPut() {
        System.out.println("LINKED LIST: " + this);
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
}

