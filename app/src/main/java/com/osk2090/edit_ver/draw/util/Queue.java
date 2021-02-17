package com.osk2090.edit_ver.draw.util;

public class Queue<E> extends List<E> implements Cloneable {
    public boolean offer(E e) {
        this.add(e);
        return true;
    }

    public Object poll() {
        return this.delete(0);//처음부터 빼낸다
    }

    @SuppressWarnings("unchecked")
    @Override
    public Queue<E> clone() throws CloneNotSupportedException {
        Queue<E> queue = new Queue<>();
        Object[] values = this.toArray();
        for (Object value : values) {
            queue.offer((E) value);
        }
        return queue;
    }

    public Iterator<E> iterator() throws CloneNotSupportedException {
        Queue<E> queue = this.clone();

        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return queue.size() > 0;
            }

            @Override
            public E next() {
                return (E) queue.poll();
            }
        };
    }
}