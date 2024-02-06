package exercises.E05_Stack;

public interface Stack<T> {
    public boolean isEmpty();
    public T pop();
    public void push(T el) throws StackOverflowError;
}
