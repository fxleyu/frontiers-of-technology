package fx.leyu.notes.service;

import java.util.List;

public interface ReviewService {
    List<String> gainReviewsOfBook(String ISBN);
    void storeReview(String ISBN, String userId, String review);
}
