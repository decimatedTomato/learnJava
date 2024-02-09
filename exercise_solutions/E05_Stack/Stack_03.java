package exercise_solutions.E05_Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
class DynamicStack<T> implements Stack<T> {
    public static final int DEFAULT_CAPACITY = 64;
    private ArrayList<T> data;

    public DynamicStack(int capacity) {
        data = new ArrayList<>(capacity);
    }
    public DynamicStack() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public T pop() {
        if (data.isEmpty()) return null;
        return data.remove(data.size()-1);
    }

    @Override
    public void push(T el) throws StackOverflowError {
        data.add(el);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public T peek() {
        T el = pop();
        push(el);
        return el;
    }

    @Override
    public void reverse() {
        Collections.reverse(data);
    }
}

public class Stack_03 {
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\t\\u001B[31m";
    private static final String STANDARD = "";
    private Random r = new Random();

    private String generateString() {
        byte[] b = new byte[1024];
        r.nextBytes(b);
        return new String(b);
    }

    private boolean testUnderflow(Stack<String> stack) {
        return stack.pop() == null;
    }
    public void start() {
        Stack<String> sStack = new StaticStack<>();
        Stack<String> dstack = new DynamicStack<>();

        System.out.println();
    }
}
