package tasks.queues;

public interface QueueI<T> {
    void push(T data);
    T pull();
}
