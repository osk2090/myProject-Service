package com.osk2090.edit_ver.draw.util;

public class Stack extends List implements Cloneable {
    public Object push(Object item) {
        this.add(item);
        return item;
    }

    public Object pop() {
        return this.delete(this.size - 1);
    }

    @Override
    public Stack clone() throws CloneNotSupportedException {

        Stack stack = new Stack();
        for (int i = 0; i < this.size; i++) {
            stack.push(this.get(i));
        }
        return stack;
    }

    public Iterator iterator() throws CloneNotSupportedException {
        Stack stack = this.clone();

        class StackIterator implements Iterator {

            public boolean hasNext() {
                return Stack.this.size > 0;
            }

            public Object next() {
                return Stack.this.pop();
            }
        }
        return new StackIterator();
    }
}