
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FeedbackAnalysis {
    public static void main(String[] args) {
        List<Feedback> feedbacks = Arrays.asList(
            new Feedback(1, "Alice", 5, "Excellent service!"),
            new Feedback(2, "Bob", 3, "Average experience."),
            new Feedback(3, "Charlie", 4, "Good service, but room for improvement."),
            new Feedback(4, "David", 2, "Very poor service.")
        );

        // Filtering feedback based on rating
        FeedbackFilter filter = feedback -> feedback.getRating() >= 4;

        // Processing feedback by printing
        FeedbackProcessor processor = feedback -> System.out.println("Processing feedback: " + feedback);

        // Applying filter and processing
        processFeedback(feedbacks, filter, processor);

        // Data Processing Pipeline
        long positiveCount = feedbacks.stream()
                .filter(feedback -> feedback.getRating() >= 4)
                .count();
        long negativeCount = feedbacks.stream()
                .filter(feedback -> feedback.getRating() < 4)
                .count();

        System.out.println("Positive Feedback Count: " + positiveCount);
        System.out.println("Negative Feedback Count: " + negativeCount);
    }

    public static void processFeedback(List<Feedback> feedbacks, FeedbackFilter filter, FeedbackProcessor processor) {
        feedbacks.stream()
                .filter(filter::filter)
                .forEach(processor::process);
    }
}
