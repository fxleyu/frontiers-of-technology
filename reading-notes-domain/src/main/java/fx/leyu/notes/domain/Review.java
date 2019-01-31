package fx.leyu.notes.domain;

public class Review {
    private String ISBN;
    private String userId;
    private String review;

    public Review(String ISBN, String userId, String review) {
        this.ISBN = ISBN;
        this.userId = userId;
        this.review = review;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Review{" +
                "ISBN='" + ISBN + '\'' +
                ", userId='" + userId + '\'' +
                ", review='" + review + '\'' +
                '}';
    }
}
