package exercise_solutions.E05_Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

public class Stack_02 {
    Random r = new Random();

    private String generateString() {
        byte[] b = new byte[1024];
        r.nextBytes(b);
        return new String(b);
    }
    public void start() {
        Stack<String> stack = new DynamicStack<>();
        stack.push(generateString());
    }
}
