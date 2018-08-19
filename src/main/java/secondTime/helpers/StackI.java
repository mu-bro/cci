package secondTime.helpers;

public interface StackI<T> {

    boolean isEmpty();
    T peek();
    T pop();
    void push(T t);
}
