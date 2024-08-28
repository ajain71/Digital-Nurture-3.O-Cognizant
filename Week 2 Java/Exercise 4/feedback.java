
public interface FeedbackFilter {
    boolean filter(Feedback feedback);
}
public interface FeedbackProcessor {
    void process(Feedback feedback);
}

