
public interface OrderFilter {
    boolean filter(Order order);
}
public interface OrderProcessor {
    void process(Order order);
}

