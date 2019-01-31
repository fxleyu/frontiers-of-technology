package fx.leyu.notes.service;

import fx.leyu.notes.domain.Review;

import java.util.List;

public interface ReviewService {
    List<String> gainReviewsOfBook(String ISBN);
    void storeReview(String ISBN, String userId, String review);
}
