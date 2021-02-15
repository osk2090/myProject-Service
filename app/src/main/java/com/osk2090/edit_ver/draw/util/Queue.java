package com.osk2090.edit_ver.draw.util;

public class Queue extends List implements Cloneable {
    public boolean offer(Object e) {
        this.add(e);
        return true;
    }

    public Object poll() {
        return this.delete(0);//처음부터 빼낸다
    }

    @Override
    public Queue clone() throws CloneNotSupportedException {
        Queue queue = new Queue();
        Object[] values = this.toArray();
        for (Object value : values) {
            queue.offer(value);
        }
        return queue;
    }

    public Iterator iterator() throws CloneNotSupportedException {
        Queue clone = this.clone();
        class QueueIterator implements Iterator {
            public boolean hasNext() {
                return Queue.this.size() > 0;
            }
            public Object next() {
                return Queue.this.poll();
            }
        }
        return new QueueIterator();
    }
}