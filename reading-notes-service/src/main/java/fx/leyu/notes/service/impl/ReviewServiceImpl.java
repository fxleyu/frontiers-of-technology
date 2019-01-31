package fx.leyu.notes.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import fx.leyu.notes.domain.Review;
import fx.leyu.notes.service.ReviewService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImpl implements ReviewService {
    private static Map<String, List<Review>> STORE = Maps.newConcurrentMap();

    @Override
    public List<Review> gainReviewsOfBook(String ISBN) {
        return MapUtils.getObject(STORE, ISBN, Lists.newArrayList());
    }

    @Override
    public void storeReview(String ISBN, String userId, String review) {
        // TODO unsafe
        List<Review> bookReviews = MapUtils.getObject(STORE, ISBN, Lists.newArrayList());
        bookReviews.add(new Review(ISBN, userId, review));
        STORE.put(ISBN, bookReviews);
    }
}
