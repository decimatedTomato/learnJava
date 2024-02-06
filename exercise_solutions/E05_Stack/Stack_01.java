package exercise_solutions.E05_Stack;

class StaticStack<T> implements Stack<T> {
    public static final int DEFAULT_CAPACITY = 64;
    private Object[] data;
    private int index;

    public StaticStack(int capacity) {
        data = new Object[capacity];
    }
    public StaticStack() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if (index == 0) {
            return null;
        }
        return (T)data[--index];
    }

    @Override
    public void push(T el) throws StackOverflowError {
        if (index > data.length) {
            throw new StackOverflowError();
        }
        data[index++] = el;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public T peek() {
        T el = pop();
        push(el);
        return el;
    }

    @SuppressWarnings("unchecked")
    private void swap(int i, int j) {
        T tmp = (T)data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
    @Override
    public void reverse() {
        for (int i = 0; i < index/2; i++) {
            swap(i, index-i-1);
        }
    }
}

public class Stack_01 {
    
}
