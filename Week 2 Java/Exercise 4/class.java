
public class Feedback {
    private int feedbackId;
    private String customerName;
    private int rating;
    private String comments;

    public Feedback(int feedbackId, String customerName, int rating, String comments) {
        this.feedbackId = feedbackId;
        this.customerName = customerName;
        this.rating = rating;
        this.comments = comments;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Feedback ID: " + feedbackId + ", Customer: " + customerName + ", Rating: " + rating + ", Comments: " + comments;
    }
}
