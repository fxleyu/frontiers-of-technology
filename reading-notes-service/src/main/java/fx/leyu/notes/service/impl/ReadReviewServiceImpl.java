package fx.leyu.notes.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import fx.leyu.notes.domain.ReadReview;
import fx.leyu.notes.service.ReadReviewService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReadReviewServiceImpl implements ReadReviewService {
    private static Map<String, List<ReadReview>> STORE = Maps.newConcurrentMap();

    @Override
    public List<ReadReview> gainReviewsOfBook(String ISBN) {
        return MapUtils.getObject(STORE, ISBN, Lists.newArrayList());
    }

    @Override
    public void storeReview(String ISBN, String userId, String review) {
        // TODO unsafe
        List<ReadReview> bookReviews = MapUtils.getObject(STORE, ISBN, Lists.newArrayList());
        bookReviews.add(new ReadReview(ISBN, userId, review));
        STORE.put(ISBN, bookReviews);
    }
}
