package Implementation;

public class AbebeQueue<E> {
    private AbebeLinkedList<E> list = new AbebeLinkedList<E>();

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public int getSize() {
        return list.size();
    }

    public void OutPut() {
        System.out.println("QUEUES:   " + this);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}