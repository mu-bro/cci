package tasks.stacks;

public interface StackI<T> {
    T pop();
    T peek();
    void push(T t);
}
