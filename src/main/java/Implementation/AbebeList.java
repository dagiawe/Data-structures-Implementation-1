package Implementation;

import java.util.Collection;
import java.util.Iterator;

public interface AbebeList<E> extends Collection<E> {

    public void add(int index, E e);

    public E get(int index);

    public int indexOf(Object e);

    public int lastIndexOf(E e);

    public E remove(int index);

    public E set(int index, E e);

    @Override
    public default boolean add(E e) {
        add(size(), e);
        return true;
    }

    @Override
    public default boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public default boolean remove(Object e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        } else
            return false;
    }

    @Override
    public default boolean containsAll(Collection<?> c) {
        Iterator<?> e = c.iterator();
        while (e.hasNext()) {
            if (!contains(e.next()))
                return false;
        }
        return true;
    }

    @Override
    public default boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (final E e : c) {
            result |= add(e);
        }
        return result;
    }

    @Override
    public default boolean removeAll(Collection<?> c) {
        boolean result = false;
        for (final Object name : c) {
            result |= remove(name);
        }
        return result;
    }

    @Override
    public default boolean retainAll(Collection<?> c) {
        boolean changed = false;
        int index = size() - 1;
        while (index >= 0) {
            E ob = get(index);
            if (c.contains(ob)) {
                remove(index);
                changed = true;
            }
            index--;
        }
        return changed;
    }

    @Override
    public default Object[] toArray() {
        Object array[] = new Object[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = get(i);
        }
        return array;
    }

    @Override
    public default <T> T[] toArray(T[] array) {
        if (array.length < size()) {
            array = (T[]) new Object[size()];
        }
        for (int i = 0; i < size(); i++) {
            array[i] = (T) get(i);
        }
        return array;
    }

    public default void OutPut() {
        System.out.println("LIST: " + this);
    }
}
