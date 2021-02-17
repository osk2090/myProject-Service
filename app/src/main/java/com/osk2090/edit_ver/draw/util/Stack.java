package com.osk2090.edit_ver.draw.util;

public class Stack<E> extends List<E> implements Cloneable {
    public E push(E item) {
        this.add(item);
        return item;
    }

    public E pop() {
        return (E) this.delete(this.size - 1);
    }

    @Override
    public Stack<E> clone() throws CloneNotSupportedException {

        Stack<E> stack = new Stack<>();
        for (int i = 0; i < this.size; i++) {
            stack.push((E) this.get(i));
        }
        return stack;
    }

    public Iterator<E> iterator() throws CloneNotSupportedException {
        Stack<E> stack = this.clone();

        return new Iterator<E>() {

            public boolean hasNext() {
                return Stack.this.size > 0;
            }

            public E next() {
                return Stack.this.pop();
            }
        };
    }
}