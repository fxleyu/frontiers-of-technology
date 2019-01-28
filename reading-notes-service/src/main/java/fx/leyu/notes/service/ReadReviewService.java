package fx.leyu.notes.service;

import fx.leyu.notes.domain.ReadReview;

import java.util.List;

public interface ReadReviewService {
    List<ReadReview> gainReviewsOfBook(String ISBN);
    void storeReview(String ISBN, String userId, String review);
}
